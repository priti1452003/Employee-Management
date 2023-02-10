package com.gl.employeemngmt.service;


import java.util.List;

import com.gl.employeemngmt.model.Employee;

public interface EmployeeService {
	public List<Employee> getEmployees();

	public Employee save(Employee employee);

	public Employee update(Employee employee);

	public void delete(Integer id);

	public Employee findById(Integer id);
	
	//public Employee sort(Employee employee);
}
