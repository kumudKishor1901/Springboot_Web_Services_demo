package com.rest.webservices.user;

import java.time.LocalDate;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;


public class User {
	private Integer id;
	
	@Size(min=2)
	private String userName;
	
	@Past
	private LocalDate birthdate;
	
	
	
	public User() {}
	public User(Integer id ,String userName, LocalDate birthdate) {
		
		this.id = id;
		this.userName = userName;
		this.birthdate = birthdate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public LocalDate getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", birthdate=" + birthdate + "]";
	}
	
	
}
