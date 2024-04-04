package com.app.car;

import com.app.car.car.Car;
import com.app.car.car.CarDto;
import org.junit.jupiter.api.Test;

import static com.app.car.car.CarMapper.CAR_MAPPER;

class CarMapperTest {

    @Test
    void toDto() {
        Car car = new Car("1", "Spark", "Gm", 1200.0);

        CarDto dto = CAR_MAPPER.toDto(car);
        System.out.println(dto);

        System.out.println(CAR_MAPPER.toEntity(dto));

    }


}