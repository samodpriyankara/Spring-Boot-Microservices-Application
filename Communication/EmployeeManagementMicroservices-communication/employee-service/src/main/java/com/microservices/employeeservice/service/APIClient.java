package com.microservices.employeeservice.service;

import com.microservices.employeeservice.dto.DepartmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8080",value = "DEPARTMENT-SERVICE")
public interface APIClient {


    @GetMapping("api/v1/department/get-by-code/{code}")
    DepartmentDTO getDepartmentByCode(@PathVariable(value = "code") String departmentCode);

}
