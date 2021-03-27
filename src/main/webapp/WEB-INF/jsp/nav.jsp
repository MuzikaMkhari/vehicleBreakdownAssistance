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
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/3/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/style.css">

<title>Vehicle Breakdown Assistance</title>
</head>
<body>
	
</body>
</html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>




<nav class="w3-bar w3-black">
<span class="branding w3-bar-item w3-mobile">Vehicle Breakdown Assistance</span>
<span class="w3-right w3-mobile">
<c:choose>
	  	<c:when test="${userSession.getUsertype() == 'ROLE_ADMIN'}">
			<a class="w3-bar-item w3-button w3-mobile w3-hover-red" href="/viewuser">View User</a>
			<a class="w3-bar-item w3-button w3-mobile w3-hover-red" href="/feedback/all">View Feedback</a>
			<div class="w3-dropdown-hover w3-hide-small">
    <button class="w3-button" title="Notifications"><i class='fa fa-user-circle'></i> ${sessionName} <i class="fa fa-caret-down"></i></button>     
    <div class="w3-dropdown-content w3-card-4 w3-bar-block">
      <a href="/logout" class="w3-bar-item w3-button w3-mobile w3-hover-red">Logout</a>
    </div>
    </div>
	  	</c:when>
	  	<c:when test="${userSession.getUsertype() == 'ROLE_USER'}">
			<a class="w3-bar-item w3-button w3-mobile w3-hover-red" href="/searchlocation">Find Mechanic</a>
			<a class="w3-bar-item w3-button w3-mobile w3-hover-red" href="/myrequest">My Request</a>
			<div class="w3-dropdown-hover w3-hide-small">
    <button class="w3-button" title="Notifications"><i class='fa fa-user-circle'></i> ${sessionName} <i class="fa fa-caret-down"></i></button>     
    <div class="w3-dropdown-content w3-card-4 w3-bar-block">
      <a href="/logout" class="w3-bar-item w3-button w3-mobile w3-hover-red">Logout</a>
    </div>
    </div>
			
	  	</c:when>
	  	<c:when test="${userSession.getUsertype() == 'ROLE_MECHANIC'}">
	    	<a class="w3-bar-item w3-button w3-mobile w3-hover-red" href="/filterrequest">View Requests</a>
			<div class="w3-dropdown-hover w3-hide-small">
    <button class="w3-button" title="Notifications"><i class='fa fa-user-circle'></i> ${sessionName} <i class="fa fa-caret-down"></i></button>     
    <div class="w3-dropdown-content w3-card-4 w3-bar-block">
      <a href="/logout" class="w3-bar-item w3-button w3-mobile w3-hover-red">Logout</a>
    </div>
    </div>
	  	</c:when>
	  	<c:otherwise>
			<a class="w3-bar-item w3-button w3-mobile w3-hover-red" href="/register">Register</a>
			<a class="w3-bar-item w3-button w3-mobile w3-hover-red" href="/login">Login</a>
	  	</c:otherwise>
	</c:choose>
  </span>
</nav>






