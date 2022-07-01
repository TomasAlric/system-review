package br.com.bootcamp.itau.systemreview.services;

import br.com.bootcamp.itau.systemreview.dtos.RoleDTO;
import br.com.bootcamp.itau.systemreview.dtos.UserDTO;
import br.com.bootcamp.itau.systemreview.dtos.UserInsertDTO;
import br.com.bootcamp.itau.systemreview.models.Role;
import br.com.bootcamp.itau.systemreview.models.User;
import br.com.bootcamp.itau.systemreview.repositories.RoleRepository;
import br.com.bootcamp.itau.systemreview.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public UserDTO insert(UserInsertDTO dto) {
        User entity = new User();
        copyDtoToEntity(dto, entity);
        entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        entity = userRepository.save(entity);
        return new UserDTO(entity);
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
}
