package com.jowdev.simpleapi.controller;

import com.jowdev.simpleapi.dto.JwtResponse;
import com.jowdev.simpleapi.dto.LoginRequest;
import com.jowdev.simpleapi.dto.RegisterRequest;
import com.jowdev.simpleapi.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Autenticação", description = "Endpoints para autenticação de usuários")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    @Operation(summary = "Registrar um novo usuário")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest) {
        authService.registerUser(registerRequest.getUsername(), registerRequest.getPassword());
        System.out.println(registerRequest.getUsername() + ": Novo usuario registrado");
        return ResponseEntity.ok("Usuário registrado com sucesso!");
    }

    @PostMapping("/login")
    @Operation(summary = "Autenticar usuário e obter token JWT")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        String jwt = authService.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword());
        System.out.println(loginRequest.getUsername() + ": Novo login");
        return ResponseEntity.ok(new JwtResponse(jwt, loginRequest.getUsername()));
    }
}