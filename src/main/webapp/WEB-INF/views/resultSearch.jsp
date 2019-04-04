<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%int count =0; %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Results For the search criteria</title>
</head>
<body>
<h3> All the Available Flights for the ${destination} are follows</h3>

	 <%! int val = 1 ;%>

<form action = "/airline/booking" method ="post">
<ul>
	 <c:forEach var="listValue" items="${values}">
		 <input type ="checkbox" name ="naming" value ="value<%=val%>"> <li>${listValue}</li></a><br><br>	
		 <% val = val + 1; %>
			</c:forEach>
			<%val=1; %>
		</ul>
		
		
		<input type = "submit" value ="Add booking">
		</form>
</body>
</html>