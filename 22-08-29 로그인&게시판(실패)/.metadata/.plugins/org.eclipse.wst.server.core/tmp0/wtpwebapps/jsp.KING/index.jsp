<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
<h1>King Login</h1>

<form action="/mem/login" method="post">
id : <input type="text" name="id">
password : <input type="text" name="password">
<button type="submit">login</button>
</form>

<c:if test="${ses.id ne null  }">
Hello!! ${ses.id } login <br> 
Your email is ${ses.email }<br>
Your age is ${ses.age} <br>
<a href="/mem/logout"> *logout</a>
<a href="/mem/list"> *Member List</a>
<a href="/brd/register"> *Write page</a>
<a href="/brd/list"> *List page</a>

</c:if>

<a href ="/mem/join" id="login1">join</a>


<script>
const msg_login = '<c:out value="${msg_login}"/>';
if(msg_login == '0'){
	alert('로그인 실패!');
}

	

}


</script>
</body>
</html>