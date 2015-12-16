<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form</title>
</head>
<body>
	<h1>Form details</h1>
	<form action="form/submit" method="post">
		<table>
			<tr>
				<td>Name:</td>
			</tr>
			<tr>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>PassWord:</td>
			</tr>
			<tr>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr><td><input type="submit" value=submit /></td></tr>
			
		</table>

	</form>
</body>
</html>