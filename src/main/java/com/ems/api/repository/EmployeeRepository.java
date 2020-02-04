package com.ems.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ems.api.model.Employee;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
		
	@Query(value="select employee0_.id as id1_2_0_, department2_.id as id1_0_1_, employee0_.birth_date as birth_da2_2_0_," + 
			" employee0_.created_by as created_3_2_0_, employee0_.created_on as created_4_2_0_, " + 
			" employee0_.email as email5_2_0_, employee0_.first_name as first_na6_2_0_," + 
			" employee0_.gender as gender7_2_0_, employee0_.hire_date as hire_dat8_2_0_," + 
			" employee0_.last_name as last_nam9_2_0_, employee0_.phone_number as phone_n10_2_0_," + 
			" department2_.created_by as created_2_0_1_, department2_.created_on as created_3_0_1_," + 
			" department2_.name as name4_0_1_ from employee employee0_ inner join " + 
			" dept_emp department1_ on employee0_.id = department1_.employee_id" + 
			" inner join department department2_ on department1_.department_id = department2_.id", nativeQuery = true)
	public List<Object[]> getEmployees();

}
