package com.app.hw;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Random;

@Mapper
public interface CarMapper {
    CarMapper CAR_MAPPER = Mappers.getMapper(CarMapper.class);

    @Mapping(target = "id", expression = "java(generateRandomId())")
    @Mapping(target = "name", source = "name")
    Car toEntity(CarDTO carDTO);

    default int generateRandomId() {
        return new Random().nextInt();
    }

}
