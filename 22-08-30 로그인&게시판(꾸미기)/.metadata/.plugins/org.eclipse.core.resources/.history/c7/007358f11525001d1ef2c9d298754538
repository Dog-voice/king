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
<h1>Member List Page</h1>
<c:forEach items="${list }" var="mvo">
	<div>
			<p>
					reg_date : ${mvo.reg_at }<br>
					last_login : ${mvo.last_login }><br>
					${mvo.nick_name }<br>
					(<a href="/mem/modify?email=${mvo.email}" > ${mvo.email}</a>)
			</p>
	</div>
</c:forEach>
</body>
</html>