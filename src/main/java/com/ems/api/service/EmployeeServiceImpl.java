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

import com.ems.api.model.Employee;
import com.ems.api.repository.EmployeeRepository;

@Service
@Transactional
/*
 * EmployeeServiceImpl used to handle business related logics of Employee entity
 * @author Netaji
 */
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeRepository employeeRepository;
	
	/*
	 * This method is used to create new employee.
	 * @param departmentObj Employee object
	 * @return This method returns new Employee object
	 */
	@Override
	public Employee createEmployee(Employee employeeObj) {

		Map<String, Object> response = new HashMap<String, Object>();
		Employee employee = new Employee();
		try {
			employee = employeeRepository.save(employeeObj);
			response.put("status", "yes");
		} catch (Exception e) {
			log.error("error in create employee");
			response.put("status", "no");
		}
		return employee;
	}

	@Override
	public Employee updateEmployee(Integer id, Employee employeeObj) {

		Map<String, Object> response = new HashMap<String, Object>();
		Employee employee = new Employee();
		try {
			employee = employeeRepository.getOne(id);
			if (employee != null) {
				employee.setFirstName(employeeObj.getFirstName());
				employee.setLastName(employeeObj.getLastName());
			} else {
				throw new Exception("Employee not found exception");
			}
			response.put("status", "yes");
		} catch (Exception e) {
			log.error("error in update employee");
			response.put("status", "no");
		}
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployee(Integer id) {

		Map<String, Object> response = new HashMap<String, Object>();
		Employee employee = new Employee();
		try {
			employee = employeeRepository.getOne(id);
			if (employee == null) {
				throw new Exception("Employee not found exception");
			}
			response.put("status", "yes");
		} catch (Exception e) {
			log.error("error in create employee");
			response.put("status", "no");
		}
		return employee;
	}

	@Override
	public List<Object[]> getEmployees() {

		Map<String, Object> response = new HashMap<String, Object>();
		List<Object[]> employeeList = new ArrayList<Object[]>();
		try {
			employeeList = employeeRepository.getEmployees();
			response.put("status", "yes");
		} catch (Exception e) {
			log.error("error in create employee");
			response.put("status", "no");
		}
		return employeeList;
	}
	
	/*
	 * This method is used to get list of employees.
	 * @return This method returns list of employees.
	 */
	@Override
	public Object deleteEmployee(Integer id) {

		Map<String, Object> response = new HashMap<String, Object>();
		try {
			Employee employee = employeeRepository.getOne(id);
			if (employee != null) {
				employeeRepository.delete(employee);
			} else {
				throw new Exception("Employee not found exception");
			}
			response.put("status", "yes");
		} catch (Exception e) {
			log.error("error in delete employee");
			response.put("status", "no");
		}
		return response;
	}

}
