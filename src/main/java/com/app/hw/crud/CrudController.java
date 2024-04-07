package com.app.hw.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class CrudController {

    private final CrudServices crudServices;

    @PostMapping("/create")
    public void createStudent(@RequestBody Student student) {
        crudServices.save(student);
    }

    @PostMapping("/update")
    public void update(@RequestBody Student student) {
        crudServices.update(student);
    }

    @PostMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        crudServices.delete(id);
    }

    @PostMapping("/get/{id}")
    public Student createStudent(@PathVariable Integer id) {
        return crudServices.getById(id);
    }


}
