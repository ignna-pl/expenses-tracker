package com.expenses.application.service;

import com.expenses.application.model.User;
import com.expenses.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createUser(String username, String password) {
        User user = new User(username, passwordEncoder.encode(password));
        userRepository.save(user);
    }

}
