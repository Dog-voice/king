<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Join Page</h1>
<form action="/mem/register" method="post">
	Email : <input type="email" name="email" placeholder="abc@example.com"><br> 
	Nick_name : <input type="text" name="nick_name" placeholder="nick_name"><br>
	Password : <input type="password" name="pwd"><br>
	<button type="submit">Sign Up</button>
</form>
</body>
</html>