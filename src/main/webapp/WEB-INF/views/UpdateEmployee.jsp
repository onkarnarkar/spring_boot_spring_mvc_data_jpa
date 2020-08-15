<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<h2>Update Employee Details</h2>
		
		<form:form modelAttribute="empObj" method="POST"
			action="/LoadUpdateEmployee2">
			<br>
			<table border="2">
				<tr>
					<th>EmployeeId</th>
					<td><form:input path="id" onchange="submit()"/></td>
				</tr>
			</table>	
		</form:form>

		<c:if test="${not empty empObj2 && message==null}">
		<h3>Below are the details for this Employee</h3>
		<form:form modelAttribute="empObj2" method="POST"
			action="/UpdateEmployee">	
			<table border="2">
				<tr>
					<th>EmployeeId</th>
					<td>
						<form:input path="id"/>
					</td>
				</tr>
				<tr>
					<th>EmployeeName</th>
					<td>
						<form:input path="name"/>
					</td>
				</tr>
				<tr>
					<th>Role</th>
					<td>
						<form:select path="role">
							<form:option value="" label="--Select--" />
							<form:option value="Sr.Analyst" label="Sr.Analyst" />
							<form:option value="Team Lead" label="TeamLead" />
							<form:option value="Associate Manager" label="Associate Manager" />
							<form:option value="Manager" label="Manager" />
							<form:option value="Sr.Manager" label="Sr.Manager" />
							<form:option value="Associate Director" label="Associate Director" />
						</form:select>
					</td>
				</tr>
				<tr>
					<th>Salary</th>
					<td>
						<form:input path="salary"/>
					</td>
				</tr>
				<tr>
					<th>Employee Date of Joining</th>
					<td>
						<form:input path="insertTime"/>
					</td>
				</tr>
			</table>
		<input type="submit" value="Update"/>
		</form:form>
		</c:if>
		<c:if test="${message!=null}">
			<div class="error">
					<!-- because of use of Spring tag it will try to fetch the message from properties file
					and hen error is not found message will be empty due to which error will come -->
					<h4>${message}</h4>
					<%-- <h4>${exception}</h4> --%>
			</div>	
		</c:if>
	</center>
</body>
</html>