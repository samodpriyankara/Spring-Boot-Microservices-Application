package com.microservices.departmentservice.repository;

import com.microservices.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface DepartmentRepo extends JpaRepository<Department,Long> {
    Department findAllByDepartmentCode(String departmentCode);
}
