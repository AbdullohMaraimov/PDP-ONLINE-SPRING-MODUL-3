package com.app.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "students")

//@NamedQueries(
//        @NamedQuery(
//                name = "students.findByGender",
//                query ="from Student s where s.gender = ?1"
//        )
//)

@NamedNativeQueries({
        @NamedNativeQuery(
                name = "students.findByGender",
                query = "select s.* from students s where s.gender = ?1",
                resultClass = Student.class
        )
})

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "student_name", length = 50, nullable = false, unique = false)
    private String name;

    @Transient
    private Integer age;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    private Date birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

}
