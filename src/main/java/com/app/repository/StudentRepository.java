package com.app.repository;

import com.app.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllByBirthDateBetween(Date year1, Date year2);

//    @Query(name = "students.findByGender")
//    List<Student> findAllByGender(Gender g);
    @Query(nativeQuery = true,  name = "students.findByGender")
    List<Student> findAllByGender(String g);

    @Query(value = "from Student s where s.group.id = ?1")
    List<Student> findAllByGroupId(Long id);

}
