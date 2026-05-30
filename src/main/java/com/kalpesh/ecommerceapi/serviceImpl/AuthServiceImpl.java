package com.kalpesh.ecommerceapi.serviceImpl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kalpesh.ecommerceapi.config.JwtUtil;
import com.kalpesh.ecommerceapi.entity.User;
import com.kalpesh.ecommerceapi.repository.UserRepository;

@Service
public class AuthServiceImpl {

    private final UserRepository repo;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(UserRepository repo,
                           PasswordEncoder encoder,
                           JwtUtil jwtUtil) {
        this.repo = repo;
        this.encoder = encoder;
        this.jwtUtil = jwtUtil;
    }

    public String register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole("USER");
        repo.save(user);
        return "User registered";
    }

    public String login(String email, String password) {

        User user = repo.findByEmail(email)
                .orElseThrow();

        if (encoder.matches(password, user.getPassword())) {
            return jwtUtil.generateToken(email);
        }

        return "Invalid credentials";
    }
}