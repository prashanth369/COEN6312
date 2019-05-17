<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<style type="text/css">
.index-page{
width: 60%;
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
#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
  display:inline-block;
}
#customers tr:nth-child(even){background-color: #f2f2f2;}
#customers tr:hover {background-color: #ddd;}
</style>

</head>
<body>

<div class ="index-page">
<div class ="inner-header">
<h2>Welcome to the Airline Reservation System  ${firstName} ${lastName} </h2>
</div>

<h3> The reserved Flights for the customer are </h3>


<table id ="customers">
<tr><c:forEach var="listValue" items="${values}">
<td>${listValue}</td>
</tr>
</c:forEach>
</table>
						
		<h4>${message}</h4>
		<p>${emptyMessage}</p>
		
		<a href ="searchResults" >  Search for Flights Availability</a><br><br>
		<a href ="cancelBooking"> Cancel the bookings</a><br><br>
		<a href = "updateBooking"> Update the Booking</a><br><br>

<h4> The Balance in the user ${firstName} for the bookings are $ ${price}</h4> 
</div>
</body>
</html>