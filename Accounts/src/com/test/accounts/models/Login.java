package com.test.accounts.models;

import java.util.Date;

public class Login {
	private String email;
	private String password;
    private Date toDate;
    
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
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
	
	public String toString() {
		return "='" + this.email + "' : '" + this.password + "'";
	}
}
