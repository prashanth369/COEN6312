<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cancel Booking</title>
</head>
<body>

<p style="color:red">${errorMessage}</p>

<h3> Select the following bookings to Make the updates to which you have booked </h3>
	 <%! int val = 1 ;%>

<form action = "/airline/updateBooking" method ="post">
<div class ="mainClass">
<ul>
	 <c:forEach var="listValue" items="${naming}">
		 <input type ="checkbox" name ="naming" value ="value<%=val%>"> <li>${listValue}</li><br><br>	
		 <% val = val + 1; %>
			</c:forEach>
			<%val=1; %>
		</ul>
		<input type = "submit" value ="submit">
		</div>
		</form>
</body>
</html>