package com.app.dto;

import lombok.Data;

@Data
public class JwtAuthResponse {
    String token;
    String refreshToken;
}
