<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Page</title>
<style type="text/css">
p{
color:red
}
</style>
</head>
<body>

<form action="/airline/register" method = "POST">
First Name : <input name ="firstName" type ="text"> <p>${errorFirstName}</p><br>
last Name : <input name ="lastName" type ="text"> <p>${errorLastName}</p> <br>
Address : <input name ="address" type ="text"> <br> <p>${errorAddress}</p>
Phone Number : <input name ="phNum" type ="text"><p>${errorPhoneNum}</p><br>
Choose User Name : <input name = userName type ="text"><p>${errorUserName}</p><br>
Password : <input name="password" type="password"><p>${errorPassword}</p><br>
<input type ="submit" value ="submit">

</form>
</body>
</html>