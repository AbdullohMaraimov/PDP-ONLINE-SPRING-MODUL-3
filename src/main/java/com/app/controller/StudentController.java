package com.app.controller;

import com.app.model.entity.Student;
import com.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public void addStudent(@RequestBody Student student) {
        service.save(student);
    }

    @GetMapping("/born-between")
    public List<Student> findAllBetweenYear(@RequestParam int year1, @RequestParam int year2) {
        return service.findAllByBirthDateBetween(year1, year2);
    }

    @GetMapping("/by-gender")
    public List<Student> findByGender(@RequestParam String gender) {
        return service.findAllByGender(gender);
    }

    @GetMapping
    public List<Student> findAll(){
        return service.findAll();
    }


    @GetMapping("/paged")
    public Page<Student> getAll(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);

        return service.findAll(pageable);
    }

    @GetMapping("/{groupId}")
    public List<Student> getAllByGroup(@PathVariable Long groupId){
        return service.findAllByGroupId(groupId);
    }
}
