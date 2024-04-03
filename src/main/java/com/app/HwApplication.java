package com.app;

import com.app.entity.AuthUser;
import com.app.entity.Role;
import com.app.repository.AuthUserRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "PDP Onine Homework 9.7",
                version = "1.0.0(snapshot)",
                contact = @Contact(
                        name = "Abdulloh Maraimov",
                        email = "maraimovabdulloh.laptop2022@gmail.com",
                        url = "https://github.com/AbdullohMaraimov"
                ),
                license = @License(
                        name = "Google 1.0.0",
                        url = "https://springdoc.org"
                ),
                description = "OpenApi documentation"
        ),
        security = {
                @SecurityRequirement(
                        name = "BearerAuth"
                )
        }
)
@SecurityScheme(
        name = "BearerAuth",
        description = "JWT auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)

public class HwApplication implements CommandLineRunner {
    @Autowired
    private AuthUserRepository userRepository;
    public static void main(String[] args) {
        SpringApplication.run(HwApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        AuthUser admin = userRepository.findByRole(Role.ROLE_ADMIN);

        if (admin == null) {
            AuthUser authUser = new AuthUser();
            authUser.setUsername("admin");
            authUser.setPassword(new BCryptPasswordEncoder().encode("admin"));
            authUser.setRole(Role.ROLE_ADMIN);

            userRepository.save(authUser);
        }

    }

    @Bean
    public GroupedOpenApi items() {
        return GroupedOpenApi.builder()
                .group("item")
                .pathsToMatch("/api/v1/item/**")
                .build();
    }

    @Bean
    public GroupedOpenApi store() {
        return GroupedOpenApi.builder()
                .group("store")
                .pathsToMatch("/api/v1/store/**")
                .build();
    }

    @Bean
    public GroupedOpenApi auth() {
        return GroupedOpenApi.builder()
                .group("auth")
                .pathsToMatch("/api/v1/auth/**")
                .build();
    }

}
