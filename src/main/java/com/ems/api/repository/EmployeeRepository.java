package com.ems.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ems.api.model.Employee;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query(value="SELECT id,first_name,last_name from employee WHERE id = :id", nativeQuery = true)
	public Object getEmployee(@Param("id") Integer id);
	
	@Query(value="select e.id,e.first_name,e.last_name,d.name from employee e left outer join dept_emp de on e.id = de.employee_id "
			+ "left outer join department d on de.department_id = d.id", nativeQuery = true)
	public List<Object>  getEmployees();

}
