<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Choose Form</title>
</head>
<body>
        <!-- form 태그를 이용하여 step2-action.jsp로 데이터 전송
         이름(text), 나이(number) 값을 전송 input tag 사용 -->
         
         <form action="step2-action.jsp">
           이름 <input type="text" name="userName"> <br>
           나이 <input type="number" name="userAge"> <br>
           <input type="submit" name="전송"><br>
          </form>

</body>
</html>