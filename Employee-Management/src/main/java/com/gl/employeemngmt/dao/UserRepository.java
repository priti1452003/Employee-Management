
package com.gl.employeemngmt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.employeemngmt.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);

}
