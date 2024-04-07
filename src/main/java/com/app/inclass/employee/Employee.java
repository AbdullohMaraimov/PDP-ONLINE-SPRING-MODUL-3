package com.app.inclass.employee;

import lombok.*;

@ToString
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Builder
public class Employee {
    private String firstName;
    private String lastName;
    private String age;
}
