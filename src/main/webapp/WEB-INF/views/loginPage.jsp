<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<style>
p{
color:red
}
body{
background-color:coral;
text-align:center;
}
</style>
</head>
<body>
	<h1>Airline Reservation System</h1>
<p>${errorMessage}</p>
<form action="/airline/login" method ="POST">
 User Name : <input type ="text" name ="userName"><br><br>
 Password : <input type ="password" name ="password"><br><br>
 <input type = "submit" value ="Submit">
 
</form>
</body>
</html>