package com.ems.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ems.api.model.Department;
import com.ems.api.service.DepartmentService;

@RestController
public class DepartmentController {

	private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);

	@Autowired
	DepartmentService departmentService;

	@PostMapping(value = "/department")
	public Department createDepartment(@RequestBody Department departmentObj) {
		log.debug("create department controller started...");
		return departmentService.createDepartment(departmentObj);
	}

	@GetMapping(value = "/department/all")
	public List<Object> getDepartments() {
		log.debug("get departments controller started...");
		return departmentService.getDepartments();
	}

}
