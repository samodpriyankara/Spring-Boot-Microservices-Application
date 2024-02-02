package com.microservices.employeeservice.service.impl;

import com.microservices.employeeservice.dto.ApiResponseDTO;
import com.microservices.employeeservice.dto.DepartmentDTO;
import com.microservices.employeeservice.dto.EmployeeDTO;
import com.microservices.employeeservice.entity.Employee;
import com.microservices.employeeservice.repository.EmployeeRepo;
import com.microservices.employeeservice.service.APIClient;
import com.microservices.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceIMPL implements EmployeeService {

    private EmployeeRepo employeeRepo;
  //  private RestTemplate restTemplate;
   // private WebClient webClient;

    @Autowired
    private APIClient apiClient;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {

        Employee employee = new Employee(
                employeeDTO.getId(),
                employeeDTO.getFirstName(),
                employeeDTO.getLastName(),
                employeeDTO.getEmail(),
                employeeDTO.getDepartmentCode()
        );

        employeeRepo.save(employee);

        return employeeDTO;
    }

// Communication with Rest Template
//    @Override
//    public ApiResponseDTO getEmployeeById(long employeeId) {
//        Employee employee = employeeRepo.findById(employeeId).get();
//
//       ResponseEntity<DepartmentDTO> dtoResponseEntity =  restTemplate.
//               getForEntity("http://localhost:8080/api/v1/department/get-by-code/"+ employee.getDepartmentCode(),
//                DepartmentDTO.class);
//
//       DepartmentDTO departmentDTO = dtoResponseEntity.getBody();
//
//        EmployeeDTO employeeDTO = new EmployeeDTO(
//                employee.getId(),
//                employee.getFirstName(),
//                employee.getLastName(),
//                employee.getEmail(),
//                employee.getDepartmentCode()
//        );
//
//        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
//        apiResponseDTO.setEmployeeDTO(employeeDTO);
//        apiResponseDTO.setDepartmentDTO(departmentDTO);
//        return apiResponseDTO;
//    }


    // Communication with Web Client
//    @Override
//    public ApiResponseDTO getEmployeeById(long employeeId) {
//        Employee employee = employeeRepo.findById(employeeId).get();
//
//      DepartmentDTO departmentDTO = webClient.get()
//              .uri("http://localhost:8080/api/v1/department/get-by-code/"+ employee.getDepartmentCode())
//              .retrieve()
//              .bodyToMono(DepartmentDTO.class)
//              .block();
//
//        EmployeeDTO employeeDTO = new EmployeeDTO(
//                employee.getId(),
//                employee.getFirstName(),
//                employee.getLastName(),
//                employee.getEmail(),
//                employee.getDepartmentCode()
//        );
//
//        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
//        apiResponseDTO.setEmployeeDTO(employeeDTO);
//        apiResponseDTO.setDepartmentDTO(departmentDTO);
//        return apiResponseDTO;
//    }


    // Communication with Spring cloudFeing Client
    @Override
    public ApiResponseDTO getEmployeeById(long employeeId) {
        Employee employee = employeeRepo.findById(employeeId).get();

DepartmentDTO departmentDTO = apiClient.getDepartmentByCode(employee.getDepartmentCode());

        EmployeeDTO employeeDTO = new EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );

        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
        apiResponseDTO.setEmployeeDTO(employeeDTO);
        apiResponseDTO.setDepartmentDTO(departmentDTO);
        return apiResponseDTO;
    }

}
