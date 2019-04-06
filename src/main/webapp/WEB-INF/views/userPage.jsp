<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Search Page</title>
<style type = "css">
p{
color:red
</style>
</head>
<body>
<p> ${errorMessage}</p>
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

</body>
</html>