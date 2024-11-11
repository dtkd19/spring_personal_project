<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="../resources/css/register.css" rel="stylesheet"/>

<jsp:include page="../layout/header.jsp" />

<div class="container-md cBox2">
	<h3 style="margin-bottom: 10px">작성한 글 수정</h3>
	<c:set value="${bdto.bvo }" var="bvo"></c:set>
	<form action="/board/modify" method="post" enctype="multipart/form-data">
	<input type="hidden" name="bno" value="${bvo.bno }">
		<div class="row g-2">
			<div class="col-sm-9">
				<input type="text" class="form-control" id="t" name="title" value="${bvo.title }"
					>
			</div>
			<div class="col-sm">
				<input type="text" class="form-control" id="w" name="writer"
					placeholder="writer" value="${bvo.writer }" readonly="readonly">
			</div>
		</div>
		<div class="mb-3">
			<label for="file" class="form-label"></label> 
			<input type="file" class="form-control" id="file" name="files" multiple="multiple" style="display:none">
			<div class="fBtn">
			<button type="button" class="btn btn-outline-info" id="trigger">첨부파일 수정</button>
			</div>
			<span id="fileZone"></span>
		</div>
		<div class="mb-3">
			<br> <label for="c" class="form-label">내용</label>
			<textarea class="form-control" id="c" rows="20" cols="5"
				name="content" >${bvo.content }</textarea>
		</div>	
		<c:set value="${bdto.flist }" var="flist"></c:set>
		<div class="mb-3">
			<ul class="list-group list-group-flush">
				<!-- 파일의 개수만큼 li를 반복하여 파일 표시 타입이 1인경우만 그림을 표시 -->
				<c:forEach items="${flist }" var="fvo">
					 <li class="list-group-item">
				  		<c:choose>
				  			<c:when test="${fvo.fileType > 0 }">
				  				<div>
				  					<img alt="" src="/upload/${fvo.saveDir }/${fvo.uuid}_${fvo.fileName}">
				  				</div>
				  			</c:when>
				  				<c:otherwise>
					  				<!-- 일반파일 : 아이콘 하나 가져와서 다운로드 가능하게 생성 -->
					  				<a href="/upload/${fvo.saveDir }/${fvo.uuid}_${fvo.fileName}" download="${fvo.fileName}">
					  				<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-file-arrow-down" viewBox="0 0 16 16">
									  <path d="M8 5a.5.5 0 0 1 .5.5v3.793l1.146-1.147a.5.5 0 0 1 .708.708l-2 2a.5.5 0 0 1-.708 0l-2-2a.5.5 0 1 1 .708-.708L7.5 9.293V5.5A.5.5 0 0 1 8 5"/>
									  <path d="M4 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zm0 1h8a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1"/>
									</svg>
					  				</a>
					  			</c:otherwise>
				  		</c:choose>
				  		<div class="fw-bold">${fvo.fileName }</div>
				  		<span class="badge text-bg-primary rounded-pill">${fvo.regDate } / ${fvo.fileSize }Bytes</span>
				  		<button type="button" data-uuid="${fvo.uuid }" class="btn btn-outline-danger btn-sm del file-x">X</button>
				 	 </li>	 	
				</c:forEach> 
			</ul>
		</div>
		
		<button type="submit" id="regBtn" class="btn btn-success">수정</button>
		<a href="/board/list"><button type="button" class="btn btn-info">목록</button></a>		
	</form>
</div>


<script type="text/javascript" src="/resources/js/boardModify.js"></script>
<script type="text/javascript" src="/resources/js/boardRegister.js"></script>

<jsp:include page="../layout/footer.jsp" />