package com.microservices.departmentservice.controller;

import com.microservices.departmentservice.dto.DepartmentDTO;
import com.microservices.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/save")
    public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO departmentDTO){
         DepartmentDTO departmentDTO1 = departmentService.saveDepartment(departmentDTO);
        return new ResponseEntity<>(departmentDTO1, HttpStatus.CREATED);
    }

    @GetMapping(value = "get-by-code/{code}")
    public ResponseEntity<DepartmentDTO> getDepartmentByCode(@PathVariable(value = "code") String departmentCode){

        DepartmentDTO departmentDTO = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(departmentDTO,HttpStatus.OK);
    }
}
