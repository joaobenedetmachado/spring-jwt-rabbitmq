package com.jowdev.simpleapi.service;

import com.jowdev.simpleapi.model.User;
import com.jowdev.simpleapi.repository.UserRepository;
import com.jowdev.simpleapi.config.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    public User registerUser(String username, String password) {
        // se o usuario existir ele dá um erro, caso nao, ele salva o usuario e tal
        if (userRepository.existsByUsername(username)) {
            throw new RuntimeException("Username já existe");
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRoles(Collections.singletonList("USER"));

        return userRepository.save(user);
    }

    public String authenticateUser(String username, String password) {
        // cria uma tentativa de autenticacao com o authenticationManager
        // se der certo essa autenticao ele vai retornar o token
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return jwtService.generateToken(authentication);
    }
}