package com.app.hw.repository;

import com.app.hw.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileDataRepository extends JpaRepository<Item, Integer> {

    Optional<Item> findByName(String fileName);
}
