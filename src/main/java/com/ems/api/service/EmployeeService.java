package com.ems.api.service;

import java.util.List;

import com.ems.api.model.Employee;

public interface EmployeeService {
	
	public Employee createEmployee(Employee employee);
	
	public Employee updateEmployee(Integer id, Employee employee);
	
	public Object getEmployee(Integer id); 
	
	public List<Object>  getEmployees(); 
	
	public Object deleteEmployee(Integer id); 
}
