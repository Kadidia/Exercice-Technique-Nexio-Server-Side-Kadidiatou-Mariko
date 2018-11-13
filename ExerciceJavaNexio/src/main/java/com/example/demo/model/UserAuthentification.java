package com.example.demo.model;

public class UserAuthentification {
	
	public UserAuthentification() {
		super();
	}
	public UserAuthentification(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	private String login;
	private String password;
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
	@Override
	public String toString() {
		return "UserAuthentification [login=" + login + ", password=" + password + "]";
	}	

}
