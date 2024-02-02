package com.microservices.employeeservice.controller;

import com.microservices.employeeservice.dto.ApiResponseDTO;
import com.microservices.employeeservice.dto.EmployeeDTO;
import com.microservices.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    private ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO employeeDTO1 = employeeService.saveEmployee(employeeDTO);
        return new ResponseEntity<>(employeeDTO1, HttpStatus.CREATED);
    }

    @GetMapping(path = "/get-by-name/{id}")
    private ResponseEntity<ApiResponseDTO> getEmployeeById(@PathVariable(value = "id") long employeeId){
        ApiResponseDTO apiResponseDTO = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(apiResponseDTO,HttpStatus.OK);
    }
}
