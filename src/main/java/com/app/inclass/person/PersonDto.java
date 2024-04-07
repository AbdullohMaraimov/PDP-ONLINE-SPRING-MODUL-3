package com.app.inclass.person;

import lombok.*;

@ToString
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Builder
public class PersonDto {
    private String name;
    private Integer age;
}
