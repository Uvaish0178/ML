package com.uvaish.backend.repository;

import com.uvaish.backend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //Employee findByName();
    // all crud database methods
}
