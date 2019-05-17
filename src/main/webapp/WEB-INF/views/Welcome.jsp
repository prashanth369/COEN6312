<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
<script src="<c:url value="/resources/js/main.js" />"></script>

<style>
p{
color:red
}
.inner-header{
color: white;
border: 1px solid black;
padding:0px;
background-color:lightgreen;
width:100%;
}
a:link, a:visited {
  background-color: lightgreen;
  color: white;
  padding: 14px 25px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}
.welcome-page{
width: 50%;
height:400px;
margin: auto;
padding:25px;
col-space:2px;
text-align:center;
border:1px solid black;
}
#left-hand{
padding-left:20px;
padding-right:100px;
padding-top:100px;
width:400px;
}
#right-hand{
padding-left:200px;
padding-right:10px;
padding-top:100px;
width:400px;
}
}
</style>
</head>
<body text="white" style="text-align:center;">
<div class ="welcome-page">
<div class ="inner-header">
<h3>Hello Welcome to Airline Reservation</h3>
</div>
<br><br>
<table>
<th id ="left-hand"><a href="logging"> For loggin</a></th>
<th id ="right-hand"><a href="register"> For registering</a></th>
</table>



</div>
</body>
</html>