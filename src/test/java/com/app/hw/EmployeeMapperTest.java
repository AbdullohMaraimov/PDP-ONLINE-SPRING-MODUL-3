package com.app.hw;

import org.junit.jupiter.api.Test;

import static com.app.hw.EmployeeMapper.EMPLOYEE_MAPPER;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeMapperTest {

    @Test
    void toEmployee() {
        EmployeeDTO employeeDTO = new EmployeeDTO(1, "Worker 1");
        Employee employee = EMPLOYEE_MAPPER.toEmployee(employeeDTO);
        System.out.println(employee);
    }

    @Test
    void toEmployeeDTO() {
        Employee employee = new Employee(1, "Worker 2");
        EmployeeDTO employeeDTO = EMPLOYEE_MAPPER.toEmployeeDTO(employee);
        System.out.println(employeeDTO);
    }
}