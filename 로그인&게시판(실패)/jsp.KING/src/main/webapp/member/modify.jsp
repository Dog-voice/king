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
     <h1>회원 정보 수정</h1>
    
    <form action="/mem/update" method="post">
    
      ID :  <input type="text" name="id" value="${mvo.id}" readonly }> <br>
      PassWoard  :  <input type="text" name="password" value="${mvo.password}"}> <br>
      Email  : <input type="text" name="email" value="${mvo.email}" }><br>
      Age :  <input type="text" name="age" value="${mvo.age}" }><br>
     <button type="submit">modify</button>
      
</form>
  
  <a href="/mem/remove?id=${mvo.id } "><button>delete</button></a>
 

</body>
</html>