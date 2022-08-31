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
<h1>Board Detail Page</h1>

<table border="1">
         <tr>
             <th>bno</th>
             <td>${bvo.bno}</td>
             
         </tr>
          <tr>
             <th>title</th>
             <td>${bvo.title}</td>
             
         </tr>
          <tr>
             <th>writer</th>
             <td>${bvo.writer}</td>
             
         </tr>
          <tr>
             <th>reg_date</th>
             <td>${bvo.reg_date }</td>
             
         </tr>
          <tr>
             <th>content</th>
             <td>${bvo.content }</td>
             
         </tr>
      </table>
      <a href="/brd/modify?bno=${bvo.bno } ">수정</a>
      <a href="/brd/remove?bno=${bvo.bno } ">삭제</a>
      <a href="/brd/list?bno=${bvo.bno } ">리스트</a>
</body>
</html>