package com.gl.employeemngmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.employeemngmt.dao.EmployeeRepository;
import com.gl.employeemngmt.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepo;

	@Override
	public List<Employee> getEmployees() {

		return employeeRepo.findAll();
	}

	@Override
	public Employee save(Employee employee) {

		return employeeRepo.save(employee);
	}

	@Override
	public Employee update(Employee employee) {

		return employeeRepo.save(employee);
	}

	@Override
	public Employee findById(Integer id) {

		return employeeRepo.getReferenceById(id);
	}

	@Override
	public void delete(Integer id) {

		Employee em = this.findById(id);
		employeeRepo.delete(em);
	}
}

	//@Override
	//public Employee sort(Employee employee) {
		//return employeeRepo.sort(employee);
	//}
	
		
		
	


