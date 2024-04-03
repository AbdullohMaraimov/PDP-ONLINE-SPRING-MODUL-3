package com.app.controller;

import com.app.dto.CreateStoreDto;
import com.app.dto.UpdateStoreDto;
import com.app.entity.Store;
import com.app.repository.StoreRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1/store/")
@RequiredArgsConstructor
@Tag(name = "Store controller", description = "This controller manages store")
//@SecurityRequirement(name = "BearerAuth") # in this way we can make specific security requrements for each controller
public class StoreController {

    private final StoreRepository storeRepository;

    @Operation(
            summary = "This endpoint created store",
            description = "This endpoint created store"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Successfully created!"
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Unauthorized / Invalid token"
            )
    })
    @PostMapping("/create")
    public ResponseEntity<Store> create(@Valid @RequestBody CreateStoreDto storeDto) {
        Store store = new Store();
        store.setName(storeDto.getName());
        store.setEmail(storeDto.getEmail());
        store.setDescription(storeDto.getDescription());

        return new ResponseEntity<>(storeRepository.save(store), HttpStatus.CREATED);
    }


    @Operation(
            summary = "This endpoint updated store",
            description = "This endpoint updated store"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Successfully updated!"
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Unauthorized / Invalid token"
            )
    })
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


    @Operation(
            summary = "This endpoint deletes store",
            description = "This endpoint deletes store by id"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully deleted!"
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Unauthorized / Invalid token"
            )
    })
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

    @Operation(
            summary = "This endpoint finds store by id",
            description = "This endpoint finds store"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully found!"
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Unauthorized / Invalid token"
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<Store> get(@PathVariable Integer id) {
        Optional<Store> store = storeRepository.findById(id);
        if (!store.isPresent()){
            throw new RuntimeException("Store not found - " + store.get().getId());
        }
        return new ResponseEntity<>(store.get(), HttpStatus.OK);
    }

    @Operation(
            summary = "This endpoint get all store",
            description = "This endpoint get all store"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully got!"
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Unauthorized / Invalid token"
            )
    })
    @GetMapping("/all")
    public ResponseEntity<List<Store>> getAll() {
        List<Store> all = storeRepository.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
}
