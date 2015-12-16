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
	<h2>Login</h2>

	<div id="frm1">
		<span class="err">${msg }</span>
		<form action="login" method="post" id="link" onsubmit="return login();">

			<table cellpadding="5px">
				<tr>
					<td>Id</td>
					<td><input type="text" name="utext" id="utext"/>
					<span class="err" id="utexterr"></span>
					<spna class="err" id="utexterr1"></spna></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="upass" id="upass"/>
					<span class="err" id="upasserr"></span></td>
				</tr>
				<tr>
					<td><input type="submit" />
				</tr>
			</table>
		</form>
	</div>
	</section>
	<%@include file="Footer.jsp"%>
</body>
</html>