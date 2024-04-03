package com.app.repository;

import com.app.entity.AuthUser;
import com.app.entity.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthUserRepository extends JpaRepository<AuthUser, Integer> {
    Optional<AuthUser> findByUsername(String username);
    AuthUser findByRole(Role role);
}
