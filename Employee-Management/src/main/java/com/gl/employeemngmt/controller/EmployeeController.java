package com.gl.employeemngmt.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.employeemngmt.model.Employee;
import com.gl.employeemngmt.service.EmployeeService;

@Controller
@RequestMapping("employees")
public class EmployeeController {
	EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@GetMapping("home")
	public String showHome() {
		return "home";
	}

	@GetMapping("showEmployeeForm")
	public String showEmployeeForm() {
		return "employee-form";
	}

	@GetMapping("list")
	public String getEmployees(Model model) {
		List<Employee> employees = employeeService.getEmployees();
		model.addAttribute("employees", employees);
		return "employees-list";
	}

	@GetMapping("save")
	public String saveEmployee(Model model, @ModelAttribute("employee") Employee employee) {
		System.out.println("in save method....");
		employeeService.save(employee);
		return "redirect:/employees/list";
	}

	@GetMapping("update")
	public String showFormForUpdate(Model model, @RequestParam("id") int id) {
		Employee employee = employeeService.findById(id);
		model.addAttribute("employee", employee);
		return "employee-form";
	}

	@GetMapping("delete")
	public String deleteEmployee(@RequestParam("id") int id) {
		employeeService.delete(id);
		return "redirect:/employees/list";
	}
	
	//@GetMapping("sort")
	//public String showFormForSorting(Model model,@ModelAttribute("employee") Employee employee) {
		//System.out.println("in sorting Method...");
	//employeeService.sort(employee);
		//return "redirect:/employees/list";
	//}

	@GetMapping("/access-denied")
	public String showAcceesdenied() {

		return "access-denied";
	}
}

