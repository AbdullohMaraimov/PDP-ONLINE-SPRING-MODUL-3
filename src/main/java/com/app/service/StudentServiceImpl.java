package com.app.service;

import com.app.model.entity.Student;
import com.app.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Pageable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@Slf4j
public class StudentServiceImpl implements StudentService{
    private final StudentRepository repository;

    @Autowired
    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Student student) {
        log.info("Student created. Name - " + student.getName());
        repository.save(student);
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Student> findAllByBirthDateBetween(int year1, int year2) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.YEAR, year1);
        calendar1.set(Calendar.MONTH, Calendar.JANUARY);
        calendar1.set(Calendar.DAY_OF_MONTH, 1);

        Date date1 = calendar1.getTime();

        Calendar calendar2 = Calendar.getInstance();
        calendar1.set(Calendar.YEAR, year2);
        calendar1.set(Calendar.MONTH, Calendar.JANUARY);
        calendar1.set(Calendar.DAY_OF_MONTH, 1);

        Date date2 = calendar2.getTime();
        return repository.findAllByBirthDateBetween(date1, date2);
    }

    @Override
    public List<Student> findAllByGender(String gender) {
        return repository.findAllByGender(gender);
    }

    @Override
    public List<Student> findAllByGroupId(Long id) {
        return repository.findAllByGroupId(id);
    }
}
