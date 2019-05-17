<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cancel Booking</title>
<style>
#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}
#customers tr:nth-child(even){background-color: #f2f2f2;}
#customers tr:hover {background-color: #ddd;}
.index-page{
width: 65%;
height:400px;
margin: auto;
padding:25px;
col-space:2px;
text-align:center;
border:1px solid black;
}
.inner-header{
color: white;
border: 1px solid black;
padding:0px;
background-color:lightgreen;
width:100%;
}
p{
color:red;
}
</style>
</head>
<body>
<p>${errorMessage}</p>
<div class ="index-page">

<div class ="inner-header">
<h3> Select the following bookings to Update the bookings  which you have booked </h3>
</div>
	 <%! int val = 1 ;%>

<form action = "/airline/updateBooking" method ="post">

<table id ="customers">
<tr><c:forEach var="listValue" items="${naming}">
<td><input type ="checkbox" name ="naming" value ="value<%=val%>">${listValue}</td>
 <% val = val + 1; %>
</tr>
</c:forEach>
<%val=1; %>
</table>

<input type = "submit" value ="submit">
		</form>
		</div>
</body>
</html>