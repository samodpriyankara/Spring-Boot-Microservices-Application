package com.microservices.employeeservice.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO {
    private long id;
    private String firstName;
    private String lastName;

    private String email;
    private String departmentCode;
}
