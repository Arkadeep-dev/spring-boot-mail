package com.employee.api.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.api.entity.Employee;
import com.employee.api.service.EmployeeServiceable;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeServiceable employeeService;

	// get all the employees
	@GetMapping("/")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> list = employeeService.getAllEmployees();
		logger.trace("all employee will be returned");
		return ResponseEntity.of(Optional.of(list));
	}

	// get a employee by id
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable String id) {
		Optional<Employee> emp = employeeService.getEmployeeById(id);
		logger.trace("one employee of particular id will be returned");
		return ResponseEntity.of(Optional.of(emp));
	}

	// add a employee
	@PostMapping("/")
	public void addOneEmployee(@RequestBody Employee employee) {
		logger.trace("adding one employee");
		employeeService.addOneEmployee(employee);
	}

	// delete a employee by id
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable String id) {
		employeeService.deleteEmployeeById(id);
		logger.trace("delete one employee by id");
		return new ResponseEntity<>(HttpStatus.OK);

	}

	// resign a employee by id)
	@PutMapping("/{id}")
	public ResponseEntity<String> resignEmployeeById(@PathVariable String id) {
		employeeService.resignEmployeeById(id);
		logger.trace("resigning a employee by id");
		return ResponseEntity.ok("Done");
	}

}
