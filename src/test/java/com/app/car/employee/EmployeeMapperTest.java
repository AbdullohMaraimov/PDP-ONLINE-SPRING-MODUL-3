package com.app.car.employee;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static com.app.car.employee.EmployeeMapper.EMPLOYEE_MAPPER;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeMapperTest {

    @Test
    void fromMap() {
        Map<String, String> params = Map.of("firstName", "Abdulloh",
                "lastName", "Maraimov",
                "age", "19");

        Employee employee = EMPLOYEE_MAPPER.fromMap(params);
        System.out.println(employee);
    }

    @Test
    void fromMap2() {
        Map<String, Object> params = Map.of("firstName", "Abdulloh",
                "lastName", "Maraimov",
                "age", 19);

        Employee employee = EMPLOYEE_MAPPER.fromMap2(params);
        System.out.println(employee);
    }
}