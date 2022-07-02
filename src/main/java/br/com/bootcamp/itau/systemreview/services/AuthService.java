package br.com.bootcamp.itau.systemreview.services;

import br.com.bootcamp.itau.systemreview.models.User;
import br.com.bootcamp.itau.systemreview.repositories.UserRepository;
import br.com.bootcamp.itau.systemreview.services.exceptions.ForbiddenException;
import br.com.bootcamp.itau.systemreview.services.exceptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public User authenticated() {

        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            return userRepository.findByEmail(username);
        } catch (Exception e) {
            throw new UnauthorizedException("Invalid user");
        }
    }

    public void validateIfUserAdmin(Long userId) {
        User user = authenticated();
        if (!user.hasHole("ROLE_MODERATOR")) {
            throw new ForbiddenException("Access denied");
        }
    }
}