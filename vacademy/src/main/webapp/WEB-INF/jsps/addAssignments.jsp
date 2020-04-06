<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Assignments</title>
</head>
<body>
	<h2>Add Assignments:</h2>
	<h3>Welcome ${instructor.firstName}</h3>
	<form action="uploadAssignments" method="post"
		enctype="multipart/form-data">
		<pre>
<input type="hidden" name="instructorId" value="${instructor.id}" />
Assignment      : <input type="file" name="assignment" />
Details         : <input type="text" name="details" />
<input type="submit" value="Add" />
		</pre>
	</form>
	<table>
		<tr>
			<th>Name</th>
			<th>Details</th>
			<th>Link</th>
		</tr>
		<c:forEach items="${assignments}" var="assignments">
			<tr>
				<td>${assignments.name}</td>
				<td>${assignments.details}</td>
				<td><a href="deleteAssignment?id=${assignments.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>