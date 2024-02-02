package com.microservices.departmentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepartmentDTO {
    private long id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
}
