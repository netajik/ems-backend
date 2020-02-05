package com.ems.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ems.api.model.Department;
import com.ems.api.repository.DepartmentRepository;


/*
 * DepartmentServiceImpl used to handle business related logics of Department entity
 * @author Netaji
 */
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private DepartmentRepository departmentRepository;
	
	/*
	 * This method is used to create new department.
	 * @param departmentObj Department object
	 * @return This method returns new Department object
	 */
	@Override
	public Department createDepartment(Department departmentObj) {

		Map<String, Object> response = new HashMap<String, Object>();
		Department department = new Department();
		try {
			department = departmentRepository.save(departmentObj);
			response.put("status", "yes");
		} catch (Exception e) {
			log.error("error in create department");
			response.put("status", "no");
		}
		return department;
	}
	
	/*
	 * This method is used to get list of departments.
	 * @return This method returns list of departments.
	 */
	@Override
	public List<Object> getDepartments() {

		Map<String, Object> response = new HashMap<String, Object>();
		List<Object> departmentList = new ArrayList<Object>();
		try {
			departmentList = departmentRepository.getDepartments();
			response.put("status", "yes");
		} catch (Exception e) {
			log.error("error in getDepartments");
			response.put("status", "no");
		}
		return departmentList;
	}
}
