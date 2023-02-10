package com.gl.employeemngmt.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gl.employeemngmt.dao.UserRepository;
import com.gl.employeemngmt.model.Role;
import com.gl.employeemngmt.model.User;
import com.gl.employeemngmt.model.UserRegistrationdto;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public User save(UserRegistrationdto registrationdto) {
		User user = new User(registrationdto.getFirstName(), registrationdto.getLastName(), registrationdto.getEmail(),
				passwordEncoder.encode(registrationdto.getPassword()), Arrays.asList(new Role("ROLE_USER")));

		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid  User Name or Password..");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				mapRolesToAuthorites(user.getRoles()));
	}

	private Collection<GrantedAuthority> mapRolesToAuthorites(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

	}

}

