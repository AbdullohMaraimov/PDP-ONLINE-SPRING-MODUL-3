package com.app.inclass.person;

import lombok.*;

@ToString
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Builder
public class PassportDto {
    private String serial;
    private String number;
}
