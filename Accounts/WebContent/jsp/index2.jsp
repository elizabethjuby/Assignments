<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  width: 200px;
  background-color: #f1f1f1;
}

li a {
  display: block;
  color: #000;
  padding: 8px 16px;
  text-decoration: none;
}

li a.active {
  background-color: #4CAF50;
  color: white;
}

li a:hover:not(.active) {
  background-color: #555;
  color: white;
}

.logo {
  overflow: hidden;
  text-align: right;
  position: right;
  margin: 0px 100px;
  height: 60px;
 
  color: blue;
  font-family: Arial;
}


.button {
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
</style>
<meta charset="utf-8">
<title>Simple home page</title>
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
<div>
<h1 align="center"></h1>
</div>
<div class="loginBox">

 <h2>View Statement</h2>
<s:if test="error">
	<s:property value="errorMessage"/>
</s:if>

<s:form  action="" validate="true">
<div class="inputBox">

</div>
<div class="container">
	<nav class="navbar navbar-expand-md navbar-dark">
	  <div class="collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav ml-auto mr-auto">
		
		  <li class="nav-item">
			<a class="nav-link" href="<s:url action="admindates"/>">Fetch Using Dates</a>
		  </li> 
	
		  <li class="nav-item">
			<a class="nav-link" href="<s:url action="adminamount"/>">Fetch using Amount</a>
		  </li>
		
	  </div>  	  
	</nav>


   


</s:form>
</div>
<body>
</html>