<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Testing JSP</title>
</head>
<body>

	<h3>Enter some Info</h3>
	<form action="ProcessInfo" method="post">
		<label>First Name: </label> <input type="text" name="fname"><br>
		<label>Last Name: </label> <input type="text" name="lname"><br>
		<label>Phone: </label> <input type="text" name="phone"><br>
		<input type="submit" value="Send">
	</form>

</body>
</html>