<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Choose Action</title>
</head>
<body>

           
           
          <c:choose>
               <c:when test="${param.userAge >= 20}">
                   ${param.userName } 님은 ${param.userAge }세 성인입니다. <br>
               </c:when>
              <c:when test="${param.userAge >= 13}">
                   ${param.userName } 님은 ${param.userAge }세 청소년입니다. <br>
               </c:when>
               <c:when test="${param.userAge >= 1}">
                   ${param.userName } 님은 ${param.userAge }세 어린이입니다. <br>
               </c:when>
                <c:otherwise>
                   ${param.userName } 님은 ${param.userAge }세 태어나지 않았습니다. <br>
               </c:otherwise>
           </c:choose>
           

</body>
</html>