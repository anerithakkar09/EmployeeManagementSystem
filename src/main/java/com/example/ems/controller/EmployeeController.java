package com.example.ems.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ems.model.Employee;
import com.example.ems.repository.EmployeeRepository;

@RestController
@Validated
public class EmployeeController
{
	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping("/employees")
	public List<Employee> getEmployees()
	{
		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}
	
	@PostMapping("/employees")
	public ResponseEntity createEmployees(@Valid @RequestBody Employee employee) throws URISyntaxException
	{
		Employee newEmployee = employeeRepository.save(employee);
		return ResponseEntity.created(new URI("employees" + newEmployee.getId())).body(newEmployee);
	}
	
	@DeleteMapping("/delete-employee")
	public ResponseEntity deleteEmployee(@RequestParam long id)
	{
		employeeRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/update-employee")
	public ResponseEntity<?> updateEmployee(@RequestParam long id, @RequestBody Employee employee)
	{
		Optional<Employee> existingEmpOptional = employeeRepository.findById(id);
		if ( existingEmpOptional.isPresent() )
		{
			Employee existingEmp = existingEmpOptional.get();
			existingEmp.setEmail(employee.getEmail());
			existingEmp.setFirstName(employee.getFirstName());
			existingEmp.setLastName(employee.getLastName());
			employeeRepository.save(existingEmp);
			
			return ResponseEntity.ok().body(existingEmp);
		}
		return ResponseEntity.notFound().build();
	}
}
