package com.app.hw.crud;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "my_students")
public class Student {

    @Id
    private int id;

    private String name;
    private String email;

}
