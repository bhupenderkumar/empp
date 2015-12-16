<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*" %>

<header>
	<h1>Employee Info</h1>
	<c:if test="${user ne null }">
		<h5 align="right">
			<a href="logout">logout</a>Hi ${user.uname} <br>
			<%! Date d=new Date();
			int hou=d.getHours();   %>
			
			<c:if test="${markin ne null }">
			You marked in at ${markin}</c:if>
			<c:if test="${markout ne null }">
			You marked OUT at ${markout}</c:if>
	</c:if>
	

	<c:if test="${user eq null }">
		<a href="Login.jsp" style="margin-right: 15px;">Login</a>
	</c:if>
	</h5>
</header>
<div id="head">
	<a href="Home.jsp">Home</a> <a href="viewall">View All Employee</a> <a
		href="ViewById.jsp">View By Id</a> <a href="AddEmployee.jsp">Insert
		New Employee</a>
	<%
		if(hou>9 && hou<10 ){ %>
	<c:if test="${markin ne null}">
		<a href="markout">Mark Out </a>
	</c:if>
	<c:if test="${markin eq null}">
		<a href="markin">Mark In</a>
	</c:if>
<%} %>
		<c:if test="${user ne null }">
		<a href="attendence">My Attendance</a>
		<a href="project">Assigned Project</a>
		</c:if>
</div>