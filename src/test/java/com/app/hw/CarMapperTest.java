package com.app.hw;

import org.junit.jupiter.api.Test;

import static com.app.hw.CarMapper.CAR_MAPPER;
import static org.junit.jupiter.api.Assertions.*;

class CarMapperTest {

    @Test
    void toEntity() {
        CarDTO carDTO = new CarDTO("Malibu");

        Car car = CAR_MAPPER.toEntity(carDTO);

        System.out.println(car);
    }
}