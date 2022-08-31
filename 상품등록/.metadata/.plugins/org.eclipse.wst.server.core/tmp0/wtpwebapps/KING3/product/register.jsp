<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Register Page</h1>
<form action="./insert.pd" method="post">
	<table border="1">
	<tr>
		<th>name</th>
		<td><input type="text" name="pname"></td>
	</tr>
	<tr>
		<th>price</th>
		<td><input type="number" name="price"></td>
	</tr>
	<tr>
		<th>made_by</th>
		<td><input type="text" name="made_by"></td>
	</tr>
	<tr>
		<td  colspan="2">
			<button type="submit">상품등록</button>
		</td>
	</tr>
	</table>
</form>

</body>
</html>