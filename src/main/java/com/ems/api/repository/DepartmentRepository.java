package com.ems.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ems.api.model.Department;

@Repository
@Transactional
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
