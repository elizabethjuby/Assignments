<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Enter Amount</title>
<link rel="stylesheet" href="css/style.css">
<div class="logo">
		<ul class="navbar-nav ml-auto">
		  <li class="nav-item">
			<a class="nav-link" href="<s:url action="logout"/>"><button type="button" class="button"> logout </button></a>
			
		  </li>  
		</ul>
	  </div>  
</head>
<body>
<div class="loginBox">
<h3>Enter Amount</h3>
 
<s:if test="error">
	<s:property value="errorMessage"/>
</s:if>

<s:form action="amountstatement" validate="true">
<div class="inputBox">
<s:textfield name="account_id" label="Account ID:"></s:textfield> 
<div class="inputBox">
<s:textfield name="fromAmount" label="From Amount:"></s:textfield> 
</div>
<div class="inputBox">
<s:textfield name="ToAmount" label="To Amount:"></s:textfield> 
</div>
<s:submit value="View Statement"/>

</s:form>
</div>
<body>
</html>