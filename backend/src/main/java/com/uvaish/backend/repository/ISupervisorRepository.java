package com.uvaish.backend.repository;

import com.uvaish.backend.model.Employee;
import com.uvaish.backend.model.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISupervisorRepository extends JpaRepository<Supervisor, Long> {

}
