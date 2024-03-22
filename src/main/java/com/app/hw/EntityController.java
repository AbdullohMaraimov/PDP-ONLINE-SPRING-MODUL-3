package com.app.hw;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class EntityController {

    private final AuthUserEntityRepository userRepository;

    public EntityController(AuthUserEntityRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity<List<EntityModel<AuthUserEntity>>> getAllUsers() {
        List<EntityModel<AuthUserEntity>> users = userRepository.findAll().stream()
                .map(user -> EntityModel.of(user,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EntityController.class).getUser(user.getId())).withSelfRel(),
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EntityController.class).getAllUsers()).withRel("users")))
                .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<AuthUserEntity>> getUser(@PathVariable Long id) {
        AuthUserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return ResponseEntity.ok(EntityModel.of(user,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EntityController.class).getUser(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EntityController.class).getAllUsers()).withRel("users")));
    }

    @PostMapping
    public ResponseEntity<EntityModel<AuthUserEntity>> createUser(@RequestBody AuthUserEntity user) {
        AuthUserEntity savedUser = userRepository.save(user);
        return ResponseEntity.created(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EntityController.class).getUser(savedUser.getId())).toUri())
                .body(EntityModel.of(savedUser,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EntityController.class).getUser(savedUser.getId())).withSelfRel(),
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EntityController.class).getAllUsers()).withRel("users")));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<AuthUserEntity>> updateUser(@PathVariable Long id, @RequestBody AuthUserEntity newUser) {
        AuthUserEntity updatedUser = userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setPassword(newUser.getPassword());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return ResponseEntity.ok(EntityModel.of(updatedUser,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EntityController.class).getUser(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EntityController.class).getAllUsers()).withRel("users")));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
