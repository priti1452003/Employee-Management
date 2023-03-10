package com.gl.employeemngmt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "Email Id", nullable = false)
	private String emailid;

	

	public Employee(int id,String firstName, String lastName, String emailid) {
		super();
		this.id=id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailid = emailid;
		
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getid() {
		return id;
	}

	public void setid(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return emailid;
	}

	public void setEmail(String emailid) {
		this.emailid = emailid;
	}

	
}

