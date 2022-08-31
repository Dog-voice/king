<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="domain.ProductVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	ProductVO pvo = (ProductVO)request.getAttribute("pvo");
%>
<body>
<h1>Detail Page</h1>
<table border="1">
	<tr>
		<th>no.</th>
		<td><%=pvo.getPno() %></td>
	</tr>
	<tr>
		<th>name</th>
		<td><%=pvo.getPname() %></td>
	</tr>
	<tr>
		<th>price</th>
		<td><%=pvo.getPrice() %></td>
	</tr>
	<tr>
		<th>reg_date</th>
		<td><%=pvo.getReg_date() %></td>
	</tr>
	<tr>
		<th>made_by</th>
		<td><%=pvo.getMade_by() %></td>
	</tr>
</table>
<a href="./modify.pd?pno=<%= pvo.getPno() %>">modify</a>&ensp;
<a href="./remove.pd?pno=<%= pvo.getPno() %>">remove</a>
</body>
</html>