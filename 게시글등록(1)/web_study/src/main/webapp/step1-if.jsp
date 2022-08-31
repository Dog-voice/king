<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!--  JSTL 선언부 -->
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTP if</title>
</head>
<body>
    <c:if test="true">
       실행해주세요.
       </c:if>
       <hr>
       
       <!--  query String 방식 -->
       <a href="step1-if.jsp?age=10&nick=파랑이">step1-if.jsp 다시 호출</a>
       <br><br>
       나이 : ${param.age }<br>
       닉네임 : ${param.nick }<br>
       <c:if test="${param.age <=5 && param.nick == '파랑이' } ">
         나이가 5세 이상입니다. 나이는 ${param.age } 세, 닉네임은 ${param.nick } 입니다.
         </c:if>
       

</body>
</html>