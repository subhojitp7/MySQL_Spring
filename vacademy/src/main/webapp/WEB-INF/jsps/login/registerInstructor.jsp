<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Instructor</title>
</head>
<body>
	<h2>Instructor Registration:</h2>
	<form action="registerInstructor" method="post">
		<pre>
First Name       : <input type="text" name="firstName" />
Last Name        : <input type="text" name="lastName" />
Subject          : <input type="text" name="subject" />
Phone            : <input type="text" name="phone" />
User Name        : <input type="text" name="email" />
Password         : <input type="password" name="password" />
Confirm Password : <input type="password" name="confirmPassword" />
	<input type="submit" value="Register" />
		</pre>
	</form>
</body>
</html>