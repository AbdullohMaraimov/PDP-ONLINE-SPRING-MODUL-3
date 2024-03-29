package com.app.controller;

import com.app.dto.CreateStoreDto;
import com.app.dto.UpdateStoreDto;
import com.app.entity.Store;
import com.app.repository.StoreRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/store/*")
@RequiredArgsConstructor
public class StoreController {

    private final StoreRepository storeRepository;

    @PostMapping("/create")
    public ResponseEntity<Store> create(@Valid @RequestBody CreateStoreDto storeDto) {
        Store store = new Store();
        store.setName(storeDto.getName());
        store.setEmail(storeDto.getEmail());
        store.setDescription(storeDto.getDescription());

        return new ResponseEntity<>(storeRepository.save(store), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Store> update(@Valid @RequestBody UpdateStoreDto updateStoreDto) {
        Optional<Store> store = storeRepository.findById(updateStoreDto.getId());

        if (store.isPresent()) {
            store.get().setName(updateStoreDto.getName());
            store.get().setEmail(updateStoreDto.getEmail());
            store.get().setDescription(updateStoreDto.getDescription());
            storeRepository.save(store.get());
        } else {
            throw new RuntimeException("No store with this id - " + updateStoreDto.getId());
        }

        return new ResponseEntity<>(store.get(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        Optional<Store> store = storeRepository.findById(id);
        if (store.isPresent()){
            storeRepository.delete(store.get());
            return new ResponseEntity<>("Successfully Deleted - Item", HttpStatus.NO_CONTENT);
        } else {
            throw new RuntimeException("Item of this id not found");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Store> get(@PathVariable Integer id) {
        Optional<Store> store = storeRepository.findById(id);
        if (!store.isPresent()){
            throw new RuntimeException("Store not found - " + store.get().getId());
        }
        return new ResponseEntity<>(store.get(), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Store>> getAll() {
        List<Store> all = storeRepository.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
}
