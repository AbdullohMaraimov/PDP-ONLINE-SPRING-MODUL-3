package com.app.inclass.person;

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
