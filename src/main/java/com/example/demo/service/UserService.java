package com.example.demo.service;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.UserSEntity;
import com.example.demo.repository.Userrepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final Userrepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserService(Userrepository repository,
                       PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserSEntity register(RegisterRequest request) {
        UserSEntity user = new UserSEntity();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return repository.save(user);
    }

    public UserSEntity findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public String login(LoginRequest request) {
        return "JWT_TOKEN"; // actual JWT added later
    }
}
