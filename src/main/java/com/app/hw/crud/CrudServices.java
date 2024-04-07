package com.app.hw.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CrudServices {

    private final StudentRepository studentRepository;

    @Async
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Async
    public void update(Student student) {
        studentRepository.save(student);
    }

    @Async
    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }

    @Async
    public Student getById(Integer id) {
        return studentRepository.findById(id).get();
    }

}
