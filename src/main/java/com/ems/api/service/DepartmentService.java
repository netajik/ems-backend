package com.ems.api.service;

import java.util.List;

import com.ems.api.model.Department;

public interface DepartmentService {
	
	public Department createDepartment(Department department);
	
	public List<Object> getDepartments();
}
