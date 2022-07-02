package br.com.bootcamp.itau.systemreview.services;

import br.com.bootcamp.itau.systemreview.dtos.RoleDTO;
import br.com.bootcamp.itau.systemreview.dtos.UserDTO;
import br.com.bootcamp.itau.systemreview.dtos.UserInsertDTO;
import br.com.bootcamp.itau.systemreview.models.Role;
import br.com.bootcamp.itau.systemreview.models.User;
import br.com.bootcamp.itau.systemreview.repositories.RoleRepository;
import br.com.bootcamp.itau.systemreview.repositories.UserRepository;
import br.com.bootcamp.itau.systemreview.services.exceptions.DatabaseException;
import br.com.bootcamp.itau.systemreview.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final BCryptPasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final AuthService authService;


    @Transactional(readOnly = true)
    public Page<UserDTO> findAllPaged(Pageable pageable) {
        Page<User> list = userRepository.findAll(pageable);
        return list.map(UserDTO::new);
    }

    @Transactional
    public UserDTO insert(UserInsertDTO dto) {
        User entity = new User();
        copyDtoToEntity(dto, entity);
        entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        entity = userRepository.save(entity);
        return new UserDTO(entity);
    }

    public void delete(Long id) {
        authService.validateIfUserAdmin(id);
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found" + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }

    }

    private void copyDtoToEntity(UserDTO dto, User entity) {
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setBirthDate(dto.getBirthDate());
        entity.setCpf(dto.getCpf());
        entity.setPoints(dto.getPoints());
        entity.getRoles().clear();
        for (RoleDTO roleDtO : dto.getRoles()) {
            Role role = roleRepository.getById(roleDtO.getId());
            entity.getRoles().add(role);
        }
    }

    public User incrementPoint(Long userId) {
        User user = userRepository.findById(userId).get();

        user.setPoints( user.getPoints() + 1 );
        userRepository.save(user);

        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);

        if (user == null) {
            logger.error("User not found: " + username);
            throw  new UsernameNotFoundException("Email not found");
        }
        logger.info("User found: " + username);
        return user;
    }
}
