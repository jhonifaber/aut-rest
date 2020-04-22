package com.aut.prueba.service;

import com.aut.prueba.model.User;
import com.aut.prueba.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }
}
