package com.app.service;

import com.app.dto.JwtAuthResponse;
import com.app.dto.RefreshTokenRequest;
import com.app.dto.SignInDto;
import com.app.dto.SignUpDto;
import com.app.entity.AuthUser;

public interface AuthService {
    AuthUser signUp(SignUpDto signUpDto);
    JwtAuthResponse signIn(SignInDto signInDto);
    JwtAuthResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
