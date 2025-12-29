package com.example.demo.config;

import com.example.demo.security.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    @Bean
    public JwtUtil jwtUtil() {

        String secret = "my-secret-key-my-secret-key-my-secret-key"; 
        // must be at least 32 bytes for HS256

        long expirationMillis = 1000 * 60 * 60; // 1 hour

        return new JwtUtil(secret, expirationMillis);
    }
}
