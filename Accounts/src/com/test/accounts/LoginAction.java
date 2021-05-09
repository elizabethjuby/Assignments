package com.test.accounts;


import java.util.Map;  
import org.apache.struts2.dispatcher.SessionMap;  
import org.apache.struts2.interceptor.SessionAware;  

import com.opensymphony.xwork2.ActionSupport;
import com.test.accounts.models.Login;
import com.test.accounts.services.UserService;

public class LoginAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -7003898299132796590L;
	
	private Login loginBean;
	private boolean error = false;
	private String errorMessage = "";
	private String emailIdForUpdate;
	private String newPassword;
	private String oldPassword;
	private String ConfirmnewPassword;
	private boolean type;
	
	
	
	

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	public String getConfirmnewPassword() {
		return ConfirmnewPassword;
	}

	public void setConfirmnewPassword(String confirmnewPassword) {
		ConfirmnewPassword = confirmnewPassword;       
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String execute() {
		System.out.println("update password called ");
		return "success";
	}
	
	public String executehome() {
		System.out.println("Execute home called");
		//if(this.sessionmap.get("type").equals("WarehouseAdmin")||this.sessionmap.get("type").equals("Engineer")||this.sessionmap.get("type").equals("System Analyst")||this.sessionmap.get("type").equals("Admin"))
			//this.setType(true);
		
		return "success";
	}
	
	public String getEmailIdForUpdate() {
		return emailIdForUpdate;
	}


	public void setEmailIdForUpdate(String emailIdForUpdate) {
		this.emailIdForUpdate = emailIdForUpdate;
	}


	public String getNewPassword() {
		return newPassword;
	}


	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	SessionMap<String,String> sessionmap;  
	  
	
	
	public String loginprocess(){ 
	    UserService userService = new UserService();
		System.out.println("login called : " + this.loginBean);
		if(userService.verifyUser(loginBean))
		{
			this.sessionmap.put("user", this.loginBean.getEmail());
			
			System.out.println("put in session map " + sessionmap.toString());
			if(sessionmap.get("user").equals("admin"))
			{
		    return "admin";
			}
			if(sessionmap.get("user").equals("user"))
			{
				return "user";
			}
			
			return "failed";
			
			
	    }  
	
	    else{  
			System.out.println("login failed : " + this.loginBean);
			this.sessionmap.put("error", "Error logging in");
	        
	    }  
		return "failed";
	} 
	  
	public void setSession(Map<String, Object> sessionMap) { 
	    sessionmap = (SessionMap) sessionMap;
	}  
	  
	public String loginpage(){
		System.out.println("loginpage called : " + sessionmap.toString());  
		this.setError(false);
		if (sessionmap.get("error") != null) {
			this.setError(true);
			this.setErrorMessage(this.sessionmap.get("error"));
			this.sessionmap.remove("error");
		}
	    return "success";  
	}
	  
	public String logout(){  
	    sessionmap.invalidate();  
	    return "success";  
	}

	public Login getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(Login loginBean) {
		System.out.println("set loginbean called"); 
		this.loginBean = loginBean;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}