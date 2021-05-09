package com.test.account.accountActionTest;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.StrutsTestCase;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionProxy;
import com.test.accounts.AccountAction;

public class TestAccountAction extends StrutsTestCase {
	
	
	
	 public void testStatementViaAmount() throws Exception {
		 
		  
	        
	 
	        ActionProxy proxy = getActionProxy("/amountstatement");
	 
	        AccountAction accountAction = (AccountAction) proxy.getAction();
	        Map<String, Object> sessionMap = new HashMap<String, Object>();
	        proxy.getInvocation().getInvocationContext().setSession(sessionMap);
	        accountAction.setAccount_id(3);
	 
	        String resultb= proxy.execute();
	 
	        assertEquals("success", accountAction.getStatementViaAmount());
	      
	 
	    }
	 
	 public void testStatementUsingFromamountToAmount() throws Exception {
		 
		  
		    	 
	        ActionProxy proxy = getActionProxy("/amountstatement");
	 
	        AccountAction accountAction = (AccountAction) proxy.getAction();
	        Map<String, Object> sessionMap = new HashMap<String, Object>();
	        proxy.getInvocation().getInvocationContext().setSession(sessionMap);
	        accountAction.setAccount_id(3);
	        accountAction.setFromAmount("500");
	        accountAction.setToAmount("1000");
	 
	        String resultb= proxy.execute();
	 
	        assertEquals("success", accountAction.getStatementViaAmount());
	     
	 
	    }
	 
	 public void testStatementUsingFromamountToAmount1() throws Exception {
		 
		  
		    	 
	        ActionProxy proxy = getActionProxy("/amountstatement");
	 
	        AccountAction accountAction = (AccountAction) proxy.getAction();
	        Map<String, Object> sessionMap = new HashMap<String, Object>();
	        proxy.getInvocation().getInvocationContext().setSession(sessionMap);
	        accountAction.setAccount_id(4);
	        accountAction.setFromAmount("700");
	        accountAction.setToAmount("1000");
	 
	        String resultb= proxy.execute();
	 
	        assertEquals("success", accountAction.getStatementViaAmount());
	      
	 
	    }
	 
	
	 
	 public void testStatementUsingDateDetails() throws Exception {
		 
		   
		    	 
	        ActionProxy proxy = getActionProxy("/datestatement");
	 
	        AccountAction accountAction = (AccountAction) proxy.getAction();
	        Map<String, Object> sessionMap = new HashMap<String, Object>();
	        proxy.getInvocation().getInvocationContext().setSession(sessionMap);
	        accountAction.setAccount_id(3);
	        accountAction.setFromDate("01/01/2011");
	        accountAction.setToDate("01/01/2012");
	 
	        String resultb= proxy.execute();
	 
	        assertEquals("success", accountAction.getStatementViaDate());
	       
	 
	    }
	 
	 public void testStatementUsingDateDetails1() throws Exception {
		 
		   
    	 
	        ActionProxy proxy = getActionProxy("/datestatement");
	 
	        AccountAction accountAction = (AccountAction) proxy.getAction();
	        Map<String, Object> sessionMap = new HashMap<String, Object>();
	        proxy.getInvocation().getInvocationContext().setSession(sessionMap);
	        accountAction.setAccount_id(4);
	        String resultb= proxy.execute();
	 
	        assertEquals("success", accountAction.getStatementViaDate());
	     
	 
	    }
	 
	 public void testStatementUsingDateDetailsNoDatesPassed() throws Exception {
		 
		   
    	 
	        ActionProxy proxy = getActionProxy("/datestatement");
	 
	        AccountAction accountAction = (AccountAction) proxy.getAction();
	        Map<String, Object> sessionMap = new HashMap<String, Object>();
	        proxy.getInvocation().getInvocationContext().setSession(sessionMap);
	        accountAction.setAccount_id(3);
	        
	 
	        String resultb= proxy.execute();
	 
	        assertEquals("success", accountAction.getStatementViaDate());
	     
	    }
	 
	 public void testgetStatementForUser() throws Exception {
		 
		   
    	 
	        ActionProxy proxy = getActionProxy("/statement");
	 
	        AccountAction accountAction = (AccountAction) proxy.getAction();
	        Map<String, Object> sessionMap = new HashMap<String, Object>();
	        proxy.getInvocation().getInvocationContext().setSession(sessionMap);
	        accountAction.setAccount_id(3);
	        
	 
	        String resultb= proxy.execute();
	 
	        assertEquals("success", accountAction.getStatementsForUser());
	       
	 
	    }

	
	 
	 
	

}
