<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Search Page</title>
<style>
p{
color:red;
}
select{
width:200px;
height:30px;
background-color:lightgreen;
}
.search{
width: 60%;
height:400px;
margin: auto;
padding:25px;
col-space:2px;
text-align:center;
border:1px solid black;
}
.searching{
margin:auto;
color: white;
border: 1px solid black;
padding:0px;
background-color:lightgreen;
width:100%;
}
input{
color:white;
background-color:blue;
border-radius:15px;
width:100px;
height:25px;
}
</style>
</head>
<body>
<p> ${errorMessage}</p>
<div class ="search">
<div class = "searching"><h3> Select the destination place to find the available flights</h3></div>
<br><br>
<form action="/airline/searchResults" method = "POST">
<select name = "destination">
<option value = "INDIA"> India</option>
<option value = "FRANCE"> France</option>
<option value = "LONDON"> London</option>
<option value = "CHICAGO"> Chicago</option>
<option value = "AUSTRALIA"> Australia</option>
</select><br> <br>
<input type = "submit" value ="submit">
</form>
</div>
</body>
</html>