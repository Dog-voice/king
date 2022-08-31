<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%
    //post일떄 한글처리
     request.setCharacterEncoding("utf-8"); 
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     
   <!-- action
       주문자 : 이름
       1. 전어
       2. 연어
       3. 우럭
       을 주문하셨습니다.-->
       
       주문자명 : ${param.customerName }<br>
       
       <c:forEach items="${paramValues.menu }" var="food" varStatus = "order">
           ${order.count }. ${food }<br>
          </c:forEach>
          을 주문하셨습니다. <br> 
     
     <hr>
     
     <C:forEach begin="1" end="5" var="num">
       ${num }<br>
     </C:forEach>

</body>
</html>