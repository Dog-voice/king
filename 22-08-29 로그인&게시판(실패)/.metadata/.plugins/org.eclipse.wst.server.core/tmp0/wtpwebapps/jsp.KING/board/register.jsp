<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Insert title here</title>

</head>

<body>

	<h1>Board Register Page</h1>

	<form action="/brd/insert" method="post">

		title : <input type="text" name="title"><br>

		writer : <input type="text" name="writer"><br>

		content : <textarea rows="3" cols="30" name="content"></textarea><br>

		<button type="submit">완료</button>
        <a href="/"> 뒤로가기 </a>
	</form>

</body>

</html>