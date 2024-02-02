package com.microservices.employeeservice.service;

import com.microservices.employeeservice.dto.ApiResponseDTO;
import com.microservices.employeeservice.dto.EmployeeDTO;

public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

    ApiResponseDTO getEmployeeById(long employeeId);
}
