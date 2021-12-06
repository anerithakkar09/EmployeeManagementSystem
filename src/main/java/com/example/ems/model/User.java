package com.example.ems.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name= "myuser3")
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotBlank(message = "username cannot be blank.")
	private String username;
	
	@JsonIgnore
	@NotBlank(message = "password cannot be blank.")
	private String password;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}	

}
