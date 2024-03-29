package com.app.controller;

import com.app.dto.JwtAuthResponse;
import com.app.dto.SignInDto;
import com.app.dto.SignUpDto;
import com.app.entity.AuthUser;
import com.app.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<AuthUser> signup(@RequestBody SignUpDto signUpDto) {
        return ResponseEntity.ok(authService.signUp(signUpDto));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthResponse> signin(@RequestBody SignInDto signInDto) {
        return ResponseEntity.ok(authService.signIn(signInDto));
    }



}
