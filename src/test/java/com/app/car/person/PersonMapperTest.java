package com.app.car.person;

import org.junit.jupiter.api.Test;

import static com.app.car.person.PersonMapper.PERSON_MAPPER;
import static org.junit.jupiter.api.Assertions.*;

class PersonMapperTest {

    @Test
    void toEntity() {
        PersonDto personDto = new PersonDto("Ali Valiev", 11);
        AddressDto addressDto = new AddressDto("Tashkent", "Sergili");
        PassportDto passportDto = new PassportDto("AB", "1234567");

        Person entity = PERSON_MAPPER.toEntity(personDto, addressDto, passportDto);
        System.out.println(entity);

    }
}