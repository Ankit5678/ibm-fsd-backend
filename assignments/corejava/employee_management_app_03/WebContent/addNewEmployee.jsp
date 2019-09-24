<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee</title>
</head>
<body>
	<h1><center>Add EMPLOYEE</center></h1>
	<form action="AddNewEmployee" method="post">
		<label for="Name"><b>NAME</b></label><br>
    	<input type="text" placeholder="Enter Name" name="name" ><br><br>
    	
    	<label for="Age"><b>AGE</b></label><br>
    	<input type="text" placeholder="Enter Age" name="age" ><br><br>
    	
    	<label for="Dept"><b>DEPARTMENT</b></label><br>
    	<input type="text" placeholder="Enter Department" name="dept" ><br><br>
    	
    	<label for="Desig"><b>DESIGNATION</b></label><br>
    	<input type="text" placeholder="Enter Designation" name="desig"><br><br>
    	
    	<label for="Country"><b>Country</b></label><br>
    	<input type="text" placeholder="Enter country" name="country" ><br><br>
    	
    	<input type="submit" value="ADD">	
	</form>
</body>
</html>