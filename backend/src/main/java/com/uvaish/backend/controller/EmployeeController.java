package com.uvaish.backend.controller;

import com.uvaish.backend.exception.ResourceNotFoundException;
import com.uvaish.backend.model.Employee;
import com.uvaish.backend.model.Supervisor;
import com.uvaish.backend.repository.EmployeeRepository;
import com.uvaish.backend.repository.ISupervisorRepository;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    // build create employee REST API
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee newEmployee = new Employee();

        newEmployee.setFirstName(employee.getFirstName());
        newEmployee.setLastName(employee.getLastName());
        newEmployee.setDob(employee.getDob());
        newEmployee.setUniversityName(employee.getUniversityName());
        newEmployee.setYearOfPassing(employee.getYearOfPassing());
        newEmployee.setPercentage(employee.getPercentage());
        newEmployee.setEmploymentHistory(employee.getEmploymentHistory());
        newEmployee.setDesignation("Employee");
        employeeRepository.save(newEmployee);

        return new ResponseEntity<>(newEmployee,HttpStatus.OK);
    }


    // build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable  long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
        return ResponseEntity.ok(employee);
    }

    // build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails) {
        Employee updateEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setDob(employeeDetails.getDob());
        updateEmployee.setUniversityName(employeeDetails.getUniversityName());
        updateEmployee.setYearOfPassing(employeeDetails.getYearOfPassing());
        updateEmployee.setPercentage(employeeDetails.getPercentage());
        updateEmployee.setEmploymentHistory(employeeDetails.getEmploymentHistory());

        employeeRepository.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }

    // build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        if (employee.getDesignation()!="Associate Supervisor"){
            employeeRepository.delete(employee);
        }


        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}