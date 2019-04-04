
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
		<a href ="searchResults" >  Search for Flights Availability</a>

</body>
</html>
