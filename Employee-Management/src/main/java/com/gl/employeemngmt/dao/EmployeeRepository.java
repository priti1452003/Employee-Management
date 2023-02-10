package com.gl.employeemngmt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.employeemngmt.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	List<Employee> findByNameContainsAndEmployeeContainsAllIgnoreCase(String name,String employee);
	//GET /users?sort_by=employee.asc and GET /users?sort_by=employee.desc
	
	List<Employee> findByOrderByEmployeeAsc(String name,String employee);

	
}

