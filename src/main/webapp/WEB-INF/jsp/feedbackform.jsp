<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<%@page import="com.zensar.vehiclebreakdown.model.User"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Feedback</h2>
	<hr>
	<form:form action="sendfeedback" method="post" modelAttribute="feedback" >
		<table>
			
			<tr>
				<td><label>Provide feed back below</label></td>
			</tr>
			<tr>
				<td><textarea name="description" >
					
				</textarea></td>
			</tr>
			<tr>
				<td><input type ="submit" name="sendfeedback" value="submit"></td>
			</tr>
		</table>
	</form:form>

</body>
</html>