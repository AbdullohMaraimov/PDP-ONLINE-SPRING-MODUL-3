package com.app.hw;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper EMPLOYEE_MAPPER = Mappers.getMapper(EmployeeMapper.class);

    @Mapping(target = "id", source = "employeeId")
    @Mapping(target = "name", source = "employeeName")
    Employee toEmployee(EmployeeDTO employeeDTO);

    @InheritInverseConfiguration
    EmployeeDTO toEmployeeDTO(Employee employee);

}
