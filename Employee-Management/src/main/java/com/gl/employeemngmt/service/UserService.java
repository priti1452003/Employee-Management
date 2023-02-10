package com.gl.employeemngmt.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.gl.employeemngmt.model.User;
import com.gl.employeemngmt.model.UserRegistrationdto;

public interface UserService extends UserDetailsService {
	public User save(UserRegistrationdto registrationdto);

}

