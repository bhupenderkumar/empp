<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<section> <c:if test="${user ne null }">
		<h2>Employee Details</h2>
		<form action="insert" method="post" id="form1" onsubmit="return valid();">
			<table id="tbl1">
				<tr>
					<td>Emp Id:</td>
					<td><input type="text" id="ueid" name="ueid" /> <span
						class="err" id="uiderr"></span></td>
				</tr>

				<tr>
					<td>Name:</td>
					<td><input type="text" name="uname" id="uname" /> <span class="err"
						id="unameerr"></span></td>
				</tr>

				<tr>
					<td>Desig:</td>
					<td><select name="udept">
							<c:forEach items="${dept}" var="dept">
								<option value="${dept}">${dept}</option>

							</c:forEach>
					</select> <span class="err" id="udepterr"></span></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="upass" id="upass"/> <span class="err"
						id="upasserr"></span></td>
				</tr>

				<tr>
					<td>Salary:</td>
					<td><input type="text" name="esal" id="esal" /><span class="err" id="esalerr"></span></td>
				</tr>
				<tr>
					<td>Employee Image</td>
					<td><input type="text" name="uimg" id="uimg"/> <span class="err"
						id="uimgerr"></span></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="submit" /></td>
				</tr>
			</table>
		</form>
	</c:if> <c:if test="${user eq null }">
		<jsp:forward page="Login.jsp">
			<jsp:param value="Ypu are not autorized" name="msg" />
		</jsp:forward></c:if> </section>
	<%@include file="Footer.jsp"%>
</body>
</html>