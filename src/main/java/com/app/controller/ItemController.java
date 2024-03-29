package com.app.controller;

import com.app.dto.CreateItemDto;
import com.app.dto.UpdateItemDto;
import com.app.entity.Item;
import com.app.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;
    @PostMapping("/create")
    public Item create(@RequestBody CreateItemDto itemDto) {
        Item item = new Item();
        item.setName(itemDto.getName());
        item.setPrice(itemDto.getPrice());

        return itemRepository.save(item);
    }

    @PutMapping("/update")
    public Item update(@RequestBody UpdateItemDto itemDto) {
        Item item = new Item();
        item.setId(itemDto.getId());
        item.setName(itemDto.getName());
        item.setPrice(itemDto.getPrice());

        return itemRepository.save(item);
    }

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

    @GetMapping("/{id}")
    public Item getById(@PathVariable Integer id) {
        Optional<Item> item = itemRepository.findById(id);
        if (item.isPresent()) {
            return item.get();
        } else {
            throw new RuntimeException("Item of this id not found");
        }
    }

    @GetMapping("/all")
    public List<Item> getAll(){
        return itemRepository.findAll();
    }
}

