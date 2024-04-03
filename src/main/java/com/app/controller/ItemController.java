package com.app.controller;

import com.app.dto.CreateItemDto;
import com.app.dto.UpdateItemDto;
import com.app.entity.Item;
import com.app.repository.ItemRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1/item")
@RequiredArgsConstructor
@Tag(name = "Item controller", description = "This controller manages items")
public class ItemController {

    private final ItemRepository itemRepository;

    @Operation(
            summary = "This endpoint creates item",
            description = "This endpoint get user information and saves it to the database"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Successfully created item"
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Unauthorized / Invalid token"
            )
    })
    @PostMapping("/create")
    public Item create(@RequestBody CreateItemDto itemDto) {
        Item item = new Item();
        item.setName(itemDto.getName());
        item.setPrice(itemDto.getPrice());

        return itemRepository.save(item);
    }

    @Operation(
            summary = "This endpoint updates item",
            description = "This endpoint get user information and updates it to the database"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Successfully updated item"
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Unauthorized / Invalid token"
            )
    })
    @PutMapping("/update")
    public Item update(@RequestBody UpdateItemDto itemDto) {
        Item item = new Item();
        item.setId(itemDto.getId());
        item.setName(itemDto.getName());
        item.setPrice(itemDto.getPrice());

        return itemRepository.save(item);
    }

    @Operation(
            summary = "This endpoint deletes item",
            description = "This endpoint get item it, finds the item with this id and deletes"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully deleted item"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Item not found!"
            )
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        Optional<Item> item = itemRepository.findById(id);
        if (item.isPresent()){
            itemRepository.delete(item.get());
            return new ResponseEntity<>("Successfully Deleted - Item", HttpStatus.NO_CONTENT);
        } else {
            throw new RuntimeException("Item of this id not found");
        }
    }

    @Operation(
            summary = "This endpoint get item by id",
            description = "This endpoint get item by id"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Item found"
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Unauthorized / Invalid token"
            )
    })
    @GetMapping("/{id}")
    public Item getById(@PathVariable Integer id) {
        Optional<Item> item = itemRepository.findById(id);
        if (item.isPresent()) {
            return item.get();
        } else {
            throw new RuntimeException("Item of this id not found");
        }
    }


    @Operation(
            summary = "This endpoint get all items",
            description = "This endpoint get all items"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Items found"
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Unauthorized / Invalid token"
            )
    })
    @GetMapping("/all")
    public List<Item> getAll(){
        return itemRepository.findAll();
    }
}

