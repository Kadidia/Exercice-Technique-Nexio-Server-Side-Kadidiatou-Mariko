package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	private int id;
	private String login;
	private String password;
	private String lastname;
	private String firstname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password + ", lastname=" + lastname
				+ ", firstname=" + firstname + "]";
	}
	

}
