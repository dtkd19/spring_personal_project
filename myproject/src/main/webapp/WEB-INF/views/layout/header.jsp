<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header.jsp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<div class="container-md">
<h1 style="text-align: center;">
	Spring Project 
</h1>
<ul class="nav justify-content-center">
  <li class="nav-item">
    <h2><a class="nav-link active" aria-current="page" href="/">메인</a></h2>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="/board/list">게시글목록</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#">회원가입</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#">로그인</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="/board/register">글쓰기</a> 
  </li>
</ul>




</div>
</body>
</html>