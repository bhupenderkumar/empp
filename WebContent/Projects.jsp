<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Information</title>
<script src="validation.js" type="text/javascript"></script>
<link href="prod.css" rel="stylesheet">
</head>
<body>
	<%@include file="Header.jsp"%>
	<section>

	<table id="tbl1">
		<h3 align="center">Assigned Projects</h3>
		<tr>
			<th>Project Name</th>
			<th>Project Description</th>
		</tr>
		<c:forEach items="${project}" var="p">
			<tr>
				<td>${p.name}</td>
				<td>${p.desc}</td>
			</tr>
		</c:forEach>
	</table>
	<div style="clear: left;">
		<a href="assignNew">Assign New Project</a>

	</div>
	<table id="frm1" style="display: none">
		<tr>
			<td>Project Name:</td>
			<td><input type="text" placeholder="project name"/></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
		</tr>

	</table>
	</section>
	<%@include file="Footer.jsp"%>
</body>
</html>