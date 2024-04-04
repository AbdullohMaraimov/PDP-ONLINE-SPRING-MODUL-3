package com.app.car.person;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper PERSON_MAPPER = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "fullName", source = "personDto.name")
    @Mapping(target = "personAddressCity", source = "addressDto.city")
    @Mapping(target = "personAddressApartment", source = "addressDto.apartment")
    @Mapping(target = "personPassportSerial", source = "passportDto.serial")
    @Mapping(target = "personPassportNumber", source = "passportDto.number")
    Person toEntity(PersonDto personDto, AddressDto addressDto, PassportDto passportDto);

}
