<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL param 연습 2</title>
</head>
<body>
   <a href="step1.jsp">step1.jsp로 이동</a>
   <hr>
   <!-- 주석처리 ctr1 + shift + /  -->
   1. 쿼리스트링(스클립틀릿)으로 파라미터를 전달 받음 <br>
   <%=request.getParameter("name") %><br>
   <%=request.getParameter("address") %><br>
   <br>
   
   2. EL 방식으로 파라미터를 전달 받음. <br>
   ${param.name }<br>
   ${param.address }<br>
   
   <hr>
   <form action="step2_1.jsp">
       닉네임 <input type="text" name="nick"> <br>
       나이 <input type="text" name="age"><br>
       <button type= "submit">전송</button>
   </form>
   
   <form action="step2_1.jsp">
   동물 <input type="text" name="nick2"> <br>
   식물 <input type="text" name="nick3"> <br>
   <button type= "submit">전송</button> 
   </form>
   
   <form action="step2_2.jsp">
   <input type="checkbox" name="food" value="삼겹살"> 삼겹살 <br>
   <input type="checkbox" name="food" value="참이슬"> 참이슬 <br>
   <input type="submit" value="전송"> 
   </form>
   

</body>
</html>