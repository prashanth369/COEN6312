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
</style>
</head>
<body>
<p>${errorMessage}</p>
<form action="/airline/login" method ="POST">
 User Name : <input type ="text" name ="userName"></br>
 Password : <input type ="password" name ="password"></br>
 <input type = "submit" value ="Submit">
 
</form>
</body>
</html>