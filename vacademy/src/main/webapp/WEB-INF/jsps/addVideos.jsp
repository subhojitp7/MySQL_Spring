<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Videos</title>
</head>
<body>
	<h2>Add Videos:</h2>
	<h3>Welcome ${instructor.firstName}</h3>
	<form action="upload" method="post" enctype="multipart/form-data">
		<pre>
<input type="hidden" name="instructorEmail" value="${instructor.email}" />
Name            : <input type="text" name="name" />
Video           : <input type="file" name="video" />
<input type="submit" value="Add" />
		</pre>
	</form>
</body>
</html>