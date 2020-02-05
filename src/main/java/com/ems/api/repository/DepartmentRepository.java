package com.ems.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ems.api.model.Department;

@Repository
@Transactional
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	
	@Query(value="SELECT id,name FROM department", nativeQuery = true)
	public List<Object> getDepartments();
}
