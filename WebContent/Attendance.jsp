<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jstl/sql_rt" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee</title>
<script src="validation.js" type="text/javascript"></script>
<link href="prod.css" rel="stylesheet">
</head>
<body>
	<%@include file="Header.jsp"%>
	<span class="err">${msg}</span>
	<table id="tbl1">
		<tr>
			<th>Attendance</th>
		</tr>
		<c:forEach items="${atten}" var="p">
			<tr>
				<td>${p}</td>
			</tr>
		</c:forEach>
	</table>

	<%@include file="Footer.jsp"%>
</body>
</html>