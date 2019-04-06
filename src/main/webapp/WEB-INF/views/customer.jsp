<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Page</title>
<style type="text/css">
input{

diaply:inline-block;
}
p{
display:inline-block;
color:red;
}

.customer-page{
border:2px solid black;
width: 700px;
height:400px;
margin: auto;
padding:25px
}
.inner-header{
color: white;
border: 1px solid black;
padding-left:2px;
background-color:lightgreen;
width:100%;

}
</style>
</head>
<body>

<div class ="customer-page">
<div class ="inner-header">
<h2>Enter the details for Registering the customer </h2>
</div>
<form action="/airline/register" method = "POST">
First Name : <input name ="firstName" type ="text"> <p>${errorFirstName}</p><br>
last Name : <input name ="lastName" type ="text"> <p>${errorLastName}</p> <br>
Address : <input name ="address" type ="text">  <p>${errorAddress}</p><br>
Phone Number : <input name ="phNum" type ="text"><p>${errorPhoneNum}</p><br>
Choose User Name : <input name = userName type ="text"><p>${errorUserName}</p><br>
Password : <input name="password" type="password"><p>${errorPassword}</p><br>
<br><br>
<input type ="submit" value ="submit">
</form>
</div>
</body>
</html>