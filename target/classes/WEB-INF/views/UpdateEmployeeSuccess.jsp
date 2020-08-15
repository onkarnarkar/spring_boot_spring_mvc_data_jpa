<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
}
</style>
</head>
<body>
	<center>
		<h2>Update Employee Details Success</h2>

		
			<br>
			<table border="2">
				<tr>
					<th>EmployeeId</th>
					<td>${empObj2.id}</td>
					
				</tr>
				<tr>
					<th>Role</th>
					
					<td>${empObj2.role}</td>
					
				</tr>
				<tr>
					<th>Salary</th>
					<td>${empObj2.salary}</td>
					
				</tr>
				<tr>
					<th>Employee Date of Joining</th>
					
					<td>
						<fmt:formatDate pattern="dd-MMM-yyyy" value="${empObj2.insertTime}"/>	
					</td>
					
				</tr>
			</table>
			<br><br><br><a href="/">Home</a>
	</center>

</body>
</html>