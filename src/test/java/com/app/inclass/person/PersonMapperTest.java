package com.app.inclass.person;

import org.junit.jupiter.api.Test;

import static com.app.inclass.person.PersonMapper.PERSON_MAPPER;

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