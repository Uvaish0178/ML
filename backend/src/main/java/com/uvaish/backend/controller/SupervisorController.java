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
@RequestMapping("/api/v1/supervisor")
public class SupervisorController {

    @Autowired
    private EmployeeRepository employeeRepository;
    private ISupervisorRepository supervisorRepository;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // build create employee REST API
    @PostMapping
    public ResponseEntity<Supervisor> createSupervisor(@RequestBody Supervisor supervisor) {
        Supervisor newSupervisor = new Supervisor();
        newSupervisor.setSupId(supervisor.getSupId());
        //newSupervisor.setEmpId(supervisor.getEmpId());


        supervisorRepository.save(newSupervisor);
        return new ResponseEntity<>(newSupervisor, HttpStatus.OK);
    }

}