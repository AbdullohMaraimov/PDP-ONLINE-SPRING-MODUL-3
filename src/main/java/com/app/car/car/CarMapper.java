package com.app.car.car;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper
public interface CarMapper {

    CarMapper CAR_MAPPER = Mappers.getMapper(CarMapper.class);
    @Mapping(target = "carName", source = "name", ignore = true)
    @Mapping(target = "carPrice", source = "price")
    CarDto toDto(Car car);

//    @Mapping(target = "name", source = "carName")
//    @Mapping(target = "price", source = "carPrice")
    @InheritInverseConfiguration
    @Mapping(target = "id", expression = "java(generateID())")
    Car toEntity(CarDto carDto);


    default String generateID(){
        return UUID.randomUUID().toString();
    }
    default Car toEntityWithCustomMethod(CarDto carDto){
        return new Car(null, carDto.getCarName(), null, carDto.getCarPrice());
    }

}
