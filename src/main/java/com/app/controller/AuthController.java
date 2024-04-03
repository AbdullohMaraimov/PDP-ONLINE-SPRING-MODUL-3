package com.app.controller;

import com.app.dto.JwtAuthResponse;
import com.app.dto.SignInDto;
import com.app.dto.SignUpDto;
import com.app.entity.AuthUser;
import com.app.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")
@Tag(description = "This is api for authentication", name = "Authentication")
public class AuthController {

    private final AuthService authService;

    @Operation(
            summary = "Authentication is done here",
            description = "This api receives user info from user and registers user"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully registered!",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(
                                            implementation = AuthUser.class
                                    )
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Unauthorized / Invalid token"
            )
    })
    @PostMapping("/signup")
    public ResponseEntity<AuthUser> signup(@RequestBody SignUpDto signUpDto) {
        return ResponseEntity.ok(authService.signUp(signUpDto));
    }

    @Operation(
            summary = "This is used to login user",
            description = "This api is used to login user. When user log in system generates jwt token" +
                    " and gives it to user, this token will be place to the header of users' every request"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "202",
                    description = "Successfully logged in!",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(
                                            implementation = AuthUser.class
                                    )
                            )
                    }
            )
    })
    @PostMapping("/signin")
    public ResponseEntity<JwtAuthResponse> signin(@RequestBody SignInDto signInDto) {
        return ResponseEntity.ok(authService.signIn(signInDto));
    }



}
