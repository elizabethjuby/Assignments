package com.test.accounts.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;  
import org.apache.struts2.interceptor.SessionAware;

import com.test.accounts.db.Db;
import com.test.accounts.models.Login;


public class UserService implements SessionAware{
	SessionMap<String,String> sessionmap;  
	
	
	public UserService() {}
	
	public boolean verifyUser(Login loginBean) {

		Connection con = null;
		try {
			if ((loginBean.getEmail().equals("admin"))&&(loginBean.getPassword().equals("admin")))
			{
				System.out.println("Admin is successfully logged in");
				return true;
			}
			if ((loginBean.getEmail().equals("user"))&&(loginBean.getPassword().equals("user")))
			{
				System.out.println("User is successfully logged in");
				return true;
			}
			con.close();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				con.close();
			} catch (Exception e) {
		    	System.out.println("Error closing connection");
			}
		}
		
	}

	

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
