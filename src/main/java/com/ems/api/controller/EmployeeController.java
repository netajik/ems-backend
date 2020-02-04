package com.ems.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ems.api.model.Employee;
import com.ems.api.service.EmployeeService;

@RestController
public class EmployeeController {

	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@PostMapping(value = "/employee")
	public Employee createEmployee(@Valid @RequestBody Employee employeeObj) {
		log.debug("create employee controller started...");
		return employeeService.createEmployee(employeeObj);
	}

	@PutMapping(value = "/employee/{id}")
	public Employee updateEmployee(@PathVariable(value = "id") Integer id, @RequestBody Employee employeeObj) {
		log.debug("update employee controller started...");
		return employeeService.updateEmployee(id, employeeObj);
	}

	@GetMapping(value = "/employee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable(value = "id") Integer id) {
		log.debug("get employee controller started...");
		return ResponseEntity.ok().body(employeeService.getEmployee(id));
	}

	@GetMapping(value = "/employee/all")
	public List<Object[]> getEmployees() {
		log.debug("get employees controller started... ");
		return employeeService.getEmployees();
	}

	@DeleteMapping(value = "/employee/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable(value = "id") Integer id) {
		log.debug("delete employee controller started...");
		return ResponseEntity.ok().body(employeeService.deleteEmployee(id));
	}

}
