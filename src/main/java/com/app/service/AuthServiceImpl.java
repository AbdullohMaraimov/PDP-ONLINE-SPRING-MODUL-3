package com.app.service;

import com.app.dto.JwtAuthResponse;
import com.app.dto.RefreshTokenRequest;
import com.app.dto.SignInDto;
import com.app.dto.SignUpDto;
import com.app.entity.AuthUser;
import com.app.entity.Role;
import com.app.repository.AuthUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final PasswordEncoder passwordEncoder;
    private final AuthUserRepository authUserRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public AuthUser signUp(SignUpDto signUpDto) {
        AuthUser user = new AuthUser();
        user.setUsername(signUpDto.getUsername());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        user.setRole(Role.ROLE_USER);

        return authUserRepository.save(user);
    }

    @Override
    public JwtAuthResponse signIn(SignInDto signInDto) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInDto.getUsername(), signInDto.getPassword()));

        AuthUser user = authUserRepository.findByUsername(signInDto.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Invalid username or password"));

        String jwt = jwtService.generateToken(user);
        String refreshToken = jwtService.generateRefreshToken(new HashMap<>(), user);

        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setToken(jwt);
        jwtAuthResponse.setRefreshToken(refreshToken);

        return jwtAuthResponse;
    }

    @Override
    public JwtAuthResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        String username = jwtService.extractUsername(refreshTokenRequest.getToken());

        AuthUser user = authUserRepository.findByUsername(username).orElseThrow();

        if (jwtService.isTokenValid(refreshTokenRequest.getToken(), user)){
            String token = jwtService.generateToken(user);

            JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
            jwtAuthResponse.setToken(token);
            jwtAuthResponse.setRefreshToken(refreshTokenRequest.getToken());

            return jwtAuthResponse;
        }

        return null;
    }
}
