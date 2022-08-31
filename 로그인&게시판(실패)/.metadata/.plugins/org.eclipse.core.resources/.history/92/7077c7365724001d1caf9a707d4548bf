<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Insert title here</title>

</head>

<body>

	<h1>

		Board List Page

	</h1>

	<table border="1">

		<tr>

			<th>bno</th>

			<th>title</th>

			<th>writer</th>

			<th>reg_date</th>

		</tr>

		<c:forEach items="${list }" var="bvo">

			<tr>

				<td>${bvo.bno }</td>

				<td><a href="/brd/detail?bno=${bvo.bno }">${bvo.title }</a></td>

				<td>${bvo.writer }</td>

				<td>${bvo.reg_date }</td>

			</tr>
       
		</c:forEach>
         
	</table>
   <a href="/"> HOME </a>
</body>

</html>