package com.app;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class TodoController {

    AtomicInteger count = new AtomicInteger();

    List<Todo> todos = new ArrayList<>(){{
        add(new Todo(count.getAndIncrement(), "Learn Rest Api", "High"));
        add(new Todo(count.getAndIncrement(), "Learn Server Api", "Medium"));
    }};

    @GetMapping(value = "/todos")
    public List<Todo> getAll() {
        return todos;
    }

    @GetMapping(value = "/todos/{id}")
    public Todo getById(@PathVariable int id) {
        return todos.stream().filter(t -> t.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new TodoNotFoundException("Todo not found"));
    }

    @PostMapping("/todos")
    public Todo create(@Valid @RequestBody Todo todo) {
        todo.setId(count.getAndIncrement()); // set id
        todos.add(todo);
        return todo;
    }

}
