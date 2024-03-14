package com.app.service;

import com.app.model.entity.Student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface StudentService {
    void save(Student student);
    Page<Student> findAll(Pageable pageable);
    List<Student> findAll();
    List<Student> findAllByBirthDateBetween(int year1, int year2);

    List<Student> findAllByGender(String gender);

    List<Student> findAllByGroupId(Long id);
}
