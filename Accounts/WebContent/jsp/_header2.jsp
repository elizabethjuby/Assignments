<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="css/common.css">
	<script type="text/javascript" src="js/sorttable.js"></script>
</head>
<body>

<!-- HEADER -->
<nav class="navbar navbar-expand-md navbar-dark">
	<div class="container">
	  <img src="./image/logo1.jpg" alt="Logo" style="height: 2em;"></img><a style="font-size: 1.5em;" class="navbar-brand" href="<s:url action="home"/>">&nbsp; &nbsp;Smart Farming System</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav ml-auto">
		  <li class="nav-item">
			<a class="nav-link" href="<s:url action="logout"/>"><button type="button" class="btn btn-outline-light"> logout </button></a>
			
		  </li>  
		</ul>
	  </div>  
	</div>
</nav>
<br/>

<!-- NAVIGATION -->

<div class="container">
	<nav class="navbar navbar-expand-md navbar-dark">
	  <div class="collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav ml-auto mr-auto">
		  <li class="nav-item">
			<a class="nav-link" href="<s:url action="discussion"/>">discussion</a>
		  </li>
		  <li class="nav-item">
			<a class="nav-link" href="<s:url action="news"/>">news</a>
		  </li>
		  <li class="nav-item">
			<a class="nav-link" href="<s:url action="crop"/>">crop</a>
		  </li>
		  <li class="nav-item">
			<a class="nav-link" href="<s:url action="fertilizer"/>">fertilizer</a>
		  </li>
		  <li class="nav-item">
			<a class="nav-link" href="<s:url action="dealer"/>">dealer</a>
		  </li> 
		   <li class="nav-item">
			<a class="nav-link" href="<s:url action="handbooks"/>">HandBooks</a>
		  </li>
	
		  <li class="nav-item">
			<a class="nav-link" href="<s:url action="training"/>">Training</a>
		  </li>  
		
		 <li class="nav-item">
			<a class="nav-link" href="<s:url action="soilanalysis"/>">Soil-Analysis</a>
		  </li>   
		 <li class="nav-item">
			<a class="nav-link" href="<s:url action="climate"/>">climate</a>
		  </li> 
		  	  </ul> 
		 
		</ul>
	  </div>  	  
	</nav>

	<div class="container-fluid  shadow p-3 mb-5 bg-white rounded">
	
	
	<!-- CONTENT -->