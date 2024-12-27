package com.example.SpringServer.controller;

import com.example.SpringServer.jwt.JwtToken;
import com.example.SpringServer.model.dto.AuthDto;
import com.example.SpringServer.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<JwtToken> login(@RequestBody AuthDto.Request request) {
        JwtToken jwtToken = this.authService.login(request);
        return ResponseEntity.status(HttpStatus.OK).body(jwtToken);
    }
}

