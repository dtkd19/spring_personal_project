<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%>
<link href="../resources/css/register.css" rel="stylesheet"/>

<jsp:include page="../layout/header.jsp" />

<sec:authentication property="principal.uvo.nickName" var="authNick"/>  
<div class="container-md cBox2">
	<h2 style="margin-bottom: 15px">글쓰기</h2>
	<form action="/board/register" method="post" enctype="multipart/form-data">
		<div class="row g-2">
		  <div class="col-sm-9">
		   <input type="text"class="form-control" id="t" name="title" placeholder="제목을 입력해주세요...">
		  </div>
		  <div class="col-sm">
		    <input type="text" class="form-control" id="w" name="writer" placeholder="writer" value="${authNick }" readonly="readonly">
		  </div>
		</div>
		<div class="mb-3">
			<label for="file" class="form-label"></label> 
			<input type="file" class="form-control" id="file" name="files" multiple="multiple" style="display:none">
			<div class="fBtn">
			<button type="button" class="btn btn-outline-info" id="trigger">첨부파일 등록</button>
			</div>
			<span id="fileZone"></span>
		</div>
		<div class="mb-3">
		<br>
			<label for="c" class="form-label">내용</label>
			<textarea class="form-control" id="c" rows="20" cols="5" name="content" placeholder="내용을 입력해주세요..."></textarea>
		</div>
		<button type="submit" class="btn btn-outline-primary" id="regBtn">등록</button>
	</form>
</div>

<script type="text/javascript" src="/resources/js/boardRegister.js"></script>

<jsp:include page="../layout/footer.jsp" />