package com.bean;

public class UserSignUpBean {
	private String Username;
	private String email;
	private String password;
	private String confirmpsw;

	public UserSignUpBean() {
		
	}
	
	public UserSignUpBean(String username, String email, String password) {
		super();
		Username = username;
		this.email = email;
		this.password = password;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;

	}
	public String getConfirmpsw() {
		return confirmpsw;
	}
	public void setConfirmpsw(String confirmpsw) {
		this.confirmpsw = confirmpsw;
	}
	

}
