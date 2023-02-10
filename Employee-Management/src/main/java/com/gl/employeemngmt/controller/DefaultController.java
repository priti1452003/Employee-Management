package com.gl.employeemngmt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {
	@GetMapping("/")
	public String showHome() {
		return "home";
	}

	@GetMapping("/access-denied")
	public String showAcceesdenied() {

		return "access-denied";
	}

}

