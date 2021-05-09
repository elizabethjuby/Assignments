<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Simple Login Form</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="loginBox">
<img class="user" src="image/user.jpg">
<h3>sign In Here</h3>
 
<s:if test="error">
	<s:property value="errorMessage"/>
</s:if>

<s:form action="loginprocess" validate="true">
<div class="inputBox">
<s:textfield name="loginBean.email" label="UserName"></s:textfield> 
</div>
<div class="inputBox">
<s:password name="loginBean.password" label="password"></s:password> 
</div>
<s:submit/>

</s:form>
</div>
<body>
</html>