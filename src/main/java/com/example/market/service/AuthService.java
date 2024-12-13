package com.example.market.service;

import com.example.market.model.User;
import com.example.market.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(String username, String password) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new IllegalStateException("이미 존재하는 사용자 이름입니다.");
        }
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(passwordEncoder.encode(password));
        userRepository.save(newUser);
    }

    public boolean authenticateUser(String username, String rawPassword) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return passwordEncoder.matches(rawPassword, user.getPassword());
        }
        return false;
    }
}
