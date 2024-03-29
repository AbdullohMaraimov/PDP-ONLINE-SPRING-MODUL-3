package com.app;

import com.app.entity.AuthUser;
import com.app.entity.Role;
import com.app.repository.AuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
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
}
