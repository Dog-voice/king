<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>King Index Page</h1>
<ul>
    <c:if test="${ses.email ne ' ' && ses.email ne null }">
    	<li><a href="/brd/register">Board Register</a></li>
    </c:if>
	<li><a href="/brd/list">Board List</a></li>
	<li><a href="/mem/login">login</a></li>
	<li><a href="/mem/join">signUp</a></li>
	<li><a href="/mem/list">Member List</a></li>
	<c:if test="${ses.email ne ' ' && ses.email ne null }">
			<li><a href="/mem/logout?email=${ses.email} ">logout</a></li>
	</c:if>
</ul>
<c:if test="${ses.email ne ' ' && ses.email ne null }">
	${ses.nick_name} login 하였습니다. <br>
	접속일자 : ${ses.reg_at } <br>
	마지막 접속 : ${ses.last_login }
</c:if> 
<script >
	const msg_login = '<c:out value = "${msg_login} "/>';
	if(msg_login === '0') {
		alert('로그인 실패~!!');
	}
</script>


</body>
</html> --%>

<!DOCTYPE html>
<html>
<head>
  <title>Bootstrap Example</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container" >
  <div class="spinner-border text-warning"></div><h1>* King Page *</h1><div class="spinner-border text-warning"></div>
  <div id="accordion">
    <div class="card">
      <div class="card-header">
        <a class="card-link" data-toggle="collapse" href="#collapseOne">
        <c:if test="${ses.email ne ' ' && ses.email ne null }">
    <a href="/brd/register">Board Register</a>      </c:if></a>
      </div>
    </div>
    
    <div class="card">
      <div class="card-header">
        <a class="card-link" data-toggle="collapse" href="#collapseOne">
        <c:if test="${ses.email ne ' ' && ses.email ne null }">
    <a href="/brd/list">Board List</a>     </c:if></a>
      </div>
    </div>
    
    <div class="card">
      <div class="card-header">
        <a class="collapsed card-link" data-toggle="collapse" href="#collapseTwo">
<a href="/mem/login">login</a>    
      </div>
    </div>
    <div class="card">
      <div class="card-header">
        <a class="collapsed card-link" data-toggle="collapse" href="#collapseThree">
       <a href="/mem/join">signUp</a>       
      </div>
      
       <div class="card">
      <div class="card-header">
        <a class="collapsed card-link" data-toggle="collapse" href="#collapseTwo">
<a href="/mem/list">Member List</a>  
      </div>
    </div>
      
       <div class="card">
      <div class="card-header">
        <a class="collapsed card-link" data-toggle="collapse" href="#collapseTwo">
        <c:if test="${ses.email ne ' ' && ses.email ne null }">
<a href="/mem/logout?email=${ses.email} ">logout</a></c:if></a>
      </div>
    </div>
    <c:if test="${ses.email ne ' ' && ses.email ne null }">
	${ses.nick_name} login 하였습니다. <br>
	접속일자 : ${ses.reg_at } <br>
	마지막 접속 : ${ses.last_login }
</c:if> 
<script >
	const msg_login = '<c:out value = "${msg_login} "/>';
	if(msg_login === '0') {
		alert('로그인 실패~!!');
	}
	
</script> 
      
    </div>
  </div>
</div>
<style>
.container{
text-align:center;
}
</style>
    
</body>
</html>