package com.app.hw;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthUserEntityRepository extends JpaRepository<AuthUserEntity, Long> {
}