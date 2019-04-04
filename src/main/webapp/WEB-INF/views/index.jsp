
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
<h2>Welcome to the Airline Reservation System  ${firstName} ${lastName} </h2>

<h3> The reserved Flights for the customer are </h3>

		<ul>
			<c:forEach var="listValue" items="${values}">
				<li>${listValue}</li>
			</c:forEach>
		</ul>
		
		<h4>${message}</h4>
		<p>${emptyMessage}</p>
		
		<a href ="searchResults" >  Search for Flights Availability</a><br><br>
		<a href ="cancelBooking"> Cancel the bookings</a><br><br>
		<a href = "updateBooking"> Update the Booking</a><br><br>

<h4> The Balance in the user ${firstName} for the bookings are $ ${price}</h4> 
</body>
</html>
