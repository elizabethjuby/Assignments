<%@ page contentType = "text/html; charset = UTF-8" %>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<html>
   <style>
   .styled-table {
   align: centre;
    border-collapse: collapse;
    margin: 25px 0;
    font-size: 0.9em;
    font-family: sans-serif;
    min-width: 600px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
     margin-left:auto; 
    margin-right:auto;
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
.styled-table thead tr {
    background-color: #009879;
    color: #ffffff;
    text-align: left;
}

.styled-table th,
.styled-table td {
    padding: 12px 15px;
}

.styled-table tbody tr {
    border-bottom: 1px solid #dddddd;
}

.styled-table tbody tr:nth-of-type(even) {
    background-color: #f3f3f3;
}

.styled-table tbody tr:last-of-type {
    border-bottom: 2px solid #009879;
}

.logo {
  overflow: hidden;
  text-align: right;
  position: right;
  margin: 0px 100px;
  height: 60px;
  background-color: pink;
  color: blue;
  font-family: Arial;
}

</style>
<meta charset="utf-8">
<title>Simple home page</title>
<link rel="stylesheet" href="css/style2.css">
<div class="logo">
		<ul class="navbar-nav ml-auto">
		  <li class="nav-item">
		  
		  <s:textfield name="accountNumber" label="Account Number" class="button" readonly="true"></s:textfield> 
		   <s:if test="type">
		  <a class="nav-link" href="<s:url action="test"/>"><button type="button" class="button" > Home </button></a>
		  </s:if>
		   <s:if test="type1">
		  <a class="nav-link" href="<s:url action="test"/>"><button type="button" class="button" > Home </button></a>
		  </s:if>
		  <s:if test="type3">
		  <a class="nav-link" href="<s:url action="user"/>"><button type="button" class="button" > Home </button></a>
		  </s:if>
			<a class="nav-link" href="<s:url action="logout"/>"><button type="button" class="button"> logout </button></a>
			
		  </li>  
		</ul>
	  </div>  
</head
>
   
   <body>
   <s:form id="form" them="xhtml">
   <!--  Statements in given date range :-->
   <div>
     </div>
     <s:if test="type">
     <div>
     
     <table class="styled-table">
			<thead >
			<tr>
				<!--  <th> ID </th>-->
				<!--<th> accounts_id</th>-->
				<th> Date Field </th>
				<th> Amount </th>
			</tr>
			</thead>
			<tbody>
			<s:iterator value="statementList">
			
				<tr>
					<!--<td> <s:property value="ID"/> </td>-->
					<!--<td> <s:property value="account_id"/> </td>-->
					<td> <s:date name="datefield" format="dd/MM/yyyy"/></td>
					<td> <s:property value="amount"/> </td>
				</tr>
			</s:iterator>
			</tbody>
		</table>
		</div>
		</s:if>
	  	<!--  Statements in given amount range :-->
	  	 <s:if test="type1">
		 <div>
     <table class="styled-table">
			<thead >
			<tr>
				<!--<th> ID </th>-->
				<!--<th> accounts_id</th>-->
				<th> Date Field </th>
				<th> Amount </th>
			</tr>
			</thead>
			<tbody>
			<s:iterator value="amountStatementList">
				<tr>
					<!--<td> <s:property value="ID"/> </td>-->
					<!--<td> <s:property value="account_id"/> </td>-->
					<td> <s:date name="datefield" format="dd/MM/yyyy"/></td>
					<td> <s:property value="amount"/> </td>
				</tr>
			</s:iterator>
			</tbody>
		</table>
		</div>
		</s:if>
		
<!--  Statements for user type :-->
      <s:if test="type3">
		 <div>
     <table class="styled-table">
			<thead >
			<tr>
				<!--<th> ID </th>-->
				<!--<th> accounts_id</th>-->
				<th> Date Field </th>
				<th> Amount </th>
			</tr>
			</thead>
			<tbody>
			<s:iterator value="threeMonthsStatementList">
				<tr>
					<!--<td> <s:property value="ID"/> </td>-->
					<!--<td> <s:property value="account_id"/> </td>-->
					<td> <s:date name="datefield" format="dd/MM/yyyy"/></td>
					<td> <s:property value="amount"/> </td>
				</tr>
			</s:iterator>
			</tbody>
		</table>
		</div>
		</s:if>
</s:form>

         
   </body>
</html>