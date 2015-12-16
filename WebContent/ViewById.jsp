<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Employee</title>
<script src="jquery1.8.js" type="text/javascript">
</script>
<link href="prod.css" rel="stylesheet">
<script>
$(document).ready(function(){

	$(".img1").mouseover(function(){
		$(this).animate({height: '+=50px'});
	});
	$(".img1").mouseout(function(){
		$(this).animate({height: '-=50px'});
	});
	
	
});
</script>
</head>
<body>
	<%@include file="Header.jsp"%>

	<section> <c:if test="${user ne null }">
		<h2>Employee Id Search</h2>
		<span class="err" >${msg1 }</span>
		<form action="viewbyid">

			<table id="link">
				<tr>
					<td>Emp Id<input type="text" name="txtid"
						value="${param.txtid}"></td>
				</tr>
				<tr>
					<td><input type="submit" value="search" /></td>
				</tr>
			</table>
		</form>

		<br>
		<br>
		<div id="frm1" align="center">

			<br>
			<c:if test="${empl ne null}">
				
				<table id="tbl1">
						<img class="img1" src="images/${empl.eimg}" height="200" width="200" />
					<tr>
						<th>Name</th>
						<th>ID</th>
						<th>Salary</th>
					</tr>
					<tr>
						<td>${empl.ename}</td>
						<td>${empl.eid}</td>
						<td>${empl.salary}</td>
						<td><a href="attendence?id=${empl.eid}" >Attendance</a></td>
					</tr>
					<tr>
					</tr>
				</table>
			</c:if>
		</div>
	</c:if> <c:if test="${user eq null }">
		<jsp:forward page="Login.jsp">
			<jsp:param value="Ypu are not autorized" name="msg" />
		</jsp:forward></c:if> </section>

	<%@include file="Footer.jsp"%>
</body>
</html>