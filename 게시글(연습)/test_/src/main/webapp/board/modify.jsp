<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/brd/update" method="post">
      bno  :  <input type="text" name="bno" value="${bvo.bno}"  readonly}> <br>
      title :  <input type="text" name="title" value="${bvo.title}" }> <br>
      writer  :  <input type="text" name="writer" value="${bvo.writer}" readonly}> <br>
      content  :  <textarea rows="3" cols="30" name="content">${bvo.content }  </textarea> <br>
      <button type="submit">수정</button>
      
</form>

</body>
</html>