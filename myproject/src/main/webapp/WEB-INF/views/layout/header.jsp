<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
 <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header.jsp</title>
<link href="../resources/css/header.css" rel="stylesheet"/>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body style="background-color: #393939">

<h1 style="text-align: center;" class="pj">
	Space Stories
</h1>
<ul class="nav justify-content-center nbar">
  <li class="nav-item">
    <h4><a class="nav-link active" aria-current="page" href="/">메인</a></h4>
  </li>
  <li class="nav-item">
    <h4> <a class="nav-link" href="/board/list">게시글목록</a></h4>
  </li>
  <sec:authorize access="isAnonymous()">
  <li class="nav-item">
     <h4><a class="nav-link" href="/user/register">회원가입</a></h4>
  </li>
  <li class="nav-item">
    <h4> <a class="nav-link" href="/user/login">로그인</a></h4>
  </li>
  </sec:authorize>
  
  <sec:authorize access="isAuthenticated()">
  <sec:authentication property="principal.uvo.authList" var="auths"/>
	  <li class="nav-item">
		  <h4> <a class="nav-link" href="/board/register">글쓰기</a></h4>
	  </li>
	  <li class="nav-item">
		  <h4> <a class="nav-link" href="/user/mypage">내정보</a></h4>
	  </li>
	  <c:if test="${auths.stream().anyMatch(authVO -> authVO.auth.equals('ROLE_ADMIN')).get()}">
	    <li class="nav-item">
	       <h4> <a class="nav-link text-danger" href="/user/list">사용자목록</a></h4>
	    </li>
	  </c:if>
	  <li class="nav-item">
		   <h4><a class="nav-link" href="/user/logout">로그아웃</a></h4>
	  </li>  
  </sec:authorize>
</ul>

</body>
</html>