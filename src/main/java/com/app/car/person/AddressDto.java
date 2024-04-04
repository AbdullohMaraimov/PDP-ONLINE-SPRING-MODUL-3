package com.app.car.person;

import lombok.*;

@ToString
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Builder
public class AddressDto {
    private String city;
    private String apartment;
}
