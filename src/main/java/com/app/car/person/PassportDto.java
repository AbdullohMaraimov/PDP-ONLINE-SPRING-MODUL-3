package com.app.car.person;

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
