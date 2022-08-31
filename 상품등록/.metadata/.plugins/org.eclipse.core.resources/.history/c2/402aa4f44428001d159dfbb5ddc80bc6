<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.ProductVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
List<ProductVO> list = (ArrayList<ProductVO>)request.getAttribute("list");	
%>
<body>
<h1>List Page</h1>
<table border="1">
<tr>
	<th>pno</th>
	<th>pname</th>
	<th>reg_date</th>
</tr>
<% for(ProductVO pvo : list) { %>
	<tr>
	<td><%=pvo.getPno() %></td>
	<td><a href="./detail.pd?pno=<%=pvo.getPno() %>"><%=pvo.getPname() %></a></td>
	<td><%=pvo.getReg_date() %></td>
	</tr>
<%} %>
</table>
</body>
</html>