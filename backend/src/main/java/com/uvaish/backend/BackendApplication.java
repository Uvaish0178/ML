package com.uvaish.backend;

import com.uvaish.backend.model.Employee;
import com.uvaish.backend.model.Supervisor;
import com.uvaish.backend.repository.EmployeeRepository;
import com.uvaish.backend.repository.ISupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
class BackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;
	private ISupervisorRepository supervisorRepository;
	@Override
	public void run(String... args) throws Exception {
		Employee manager=new Employee();
		manager.setFirstName("John");

		Employee emp1 = new Employee();
		emp1.setFirstName("James");

		Employee emp2 = new Employee();
		emp2.setFirstName("Anna");

		emp1.setManager(manager);
		emp2.setManager(manager);
		manager.getSubordinates().add(emp1);
		manager.getSubordinates().add(emp2);

//		Supervisor supervisor = new Supervisor();
//		supervisor.setSupName("John 1");

		/*
		Employee employee = new Employee();
		employee.setFirstName("John 1");
		employee.setLastName("Wick 1");
		employee.setDob("3 Jan 1997");
		employee.setUniversityName("MRIIRS");
		employee.setYearOfPassing(2017);
		employee.setPercentage(66.6);
		employee.setEmploymentHistory("Worked at company abc for 2 yrs, and def for 1 year");
		employee.setDesignation("Associate Supervisor");
		employeeRepository.save(employee);

		Employee employee1 = new Employee();
		employee1.setFirstName("John 2");
		employee1.setLastName("Wick 2");
		employee1.setDob("3 Jan 1997");
		employee1.setUniversityName("MRIIRS");
		employee1.setYearOfPassing(2017);
		employee1.setPercentage(66.6);
		employee1.setEmploymentHistory("Worked at company abc for 2 yrs, and def for 1 year");
		employee1.setDesignation("Employee");
		employeeRepository.save(employee1);

		Employee employee2 = new Employee();
		employee2.setFirstName("John 3");
		employee2.setLastName("Wick 3");
		employee2.setDob("3 Jan 1997");
		employee2.setUniversityName("MRIIRS");
		employee2.setYearOfPassing(2017);
		employee2.setPercentage(66.6);
		employee2.setEmploymentHistory("Worked at company abc for 2 yrs, and def for 1 year");
		employee2.setDesignation("Employee");
		employeeRepository.save(employee);
*/

//		Employee employee1 = new Employee();
//		employee1.setFirstName("John");
//		employee1.setLastName("Cena");
//		employee1.setEmailId("cena@gmail.com");
//		employeeRepository.save(employee1);
	}
}