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
    <!-- 
       form 이용하여 step4-action.jsp로 전송 method = "POST"
       주문자 : 이름
       전어 : checkbox
       연어 :
       우럭
       주문하기
       
       action
       주문자 : 이름
       1. 전어
       2. 연어
       3. 우럭
       을 주문하셨습니다.
     -->
     
     <form action="step4-action.jsp" method="POST">
           주문자 : <input type="text" name="customerName"> <br>
           전어 <input type="checkbox" name="menu" value="전어" ><br>
           연어 <input type="checkbox" name="menu" value="연어"><br>
           우럭 <input type="checkbox" name="menu" value="우럭"><br>
           <input type="submit" value="주문"><br>
          </form>

</body>
</html>