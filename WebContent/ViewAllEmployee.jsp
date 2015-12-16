<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script src="jquery1.8.js" type="text/javascript">
</script>
<script>
$(document).ready(function(){

	$(".img1").mouseover(function(){
		$(this).animate({height: '+=50px'},'slow');
	});
	$(".img1").mouseout(function(){
		$(this).animate({height: '-=50px'},'slow');
	});
	
	
});

</script>
<title>Add Employee</title>
<link href="prod.css" rel="stylesheet">
</head>
<body>
	<%@include file="Header.jsp"%>
	<section> <c:if test="${user ne null }">
		<table id="tbl1">
			<tr>
				<th>Name</th>
				<th>ID</th>
				<th>salary</th>
				<th>Image</th>
			</tr>
			<c:forEach items="${empList}" var="emp">
				<tr>
					<td>${emp.ename}</td>
					<td>${emp.eid}</td>
					<td>${emp.salary}</td>
					<td><img  class="img1" src="images/${emp.eimg}" height="100" width="100"  style="position:relative"/></td>
					<td><a href="attendence?id=${emp.eid}" >Attendance</a></td>
				</tr>
			</c:forEach>
			<tr>
			</tr>
		</table>
	</c:if> <c:if test="${user eq null }">
		<jsp:forward page="Login.jsp">
			<jsp:param value="Ypu are not autorized" name="msg" />
		</jsp:forward></c:if> </section>
	<%@include file="Footer.jsp"%>
</body>
</html>