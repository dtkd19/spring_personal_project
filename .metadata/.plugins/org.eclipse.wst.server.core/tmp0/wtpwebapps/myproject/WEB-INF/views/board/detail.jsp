<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../layout/header.jsp" />

	<div class="container-md">
	<c:set value="${bdto.bvo }" var="bvo"></c:set>
	
		<div class="dheader">
			<div class="dtitle">
				<h3>${bvo.title }</h3>
			</div>		
			<div class="dwriter">
				<span>${bvo.writer } ${bvo.regDate }</span>
				<div class="dinfo">
				<span class="badge text-bg-info"> 조회 ${bvo.readCount }</span>
				<span class="badge text-bg-info"> 댓글 ${bvo.readCount }</span>
				</div>
			</div>	
		</div>
		<c:set value="${bdto.flist }" var="flist"></c:set>
		<div class="dcontent" style="padding: 20px">
			<c:forEach items="${flist }" var="fvo">
				 <li class="list-group-item">
			  		<c:choose>
			  			<c:when test="${fvo.fileType > 0 }">
			  				<div>
			  					<img alt="" src="/upload/${fvo.saveDir }/${fvo.uuid}_${fvo.fileName}">
			  				</div>
					  		<span class="badge text-bg-info rounded-pill">${fvo.regDate }</span>
			  			</c:when>
			  			<c:otherwise>
			  				<!-- 일반파일 : 아이콘 하나 가져와서 다운로드 가능하게 생성 -->
			  				<a href="/upload/${fvo.saveDir }/${fvo.uuid}_${fvo.fileName}" download="${fvo.fileName}">
			  				<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-file-arrow-down" viewBox="0 0 16 16">
							  <path d="M8 5a.5.5 0 0 1 .5.5v3.793l1.146-1.147a.5.5 0 0 1 .708.708l-2 2a.5.5 0 0 1-.708 0l-2-2a.5.5 0 1 1 .708-.708L7.5 9.293V5.5A.5.5 0 0 1 8 5"/>
							  <path d="M4 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zm0 1h8a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1"/>
							</svg>
			  				</a>
				  		<div class="fw-bold">${fvo.fileName }</div>
				  		<span class="badge text-bg-primary rounded-pill">${fvo.regDate } / ${fvo.fileSize }Bytes</span>
			  			</c:otherwise>
			  		</c:choose>
			 	 </li>	 	
			</c:forEach> 	
			${bvo.content }	
		</div>
		<a href="/board/modify?bno=${bvo.bno }"><button type="button" class="btn btn-primary">수정</button></a>
		<a href="/board/delete?bno=${bvo.bno }"><button type="button" class="btn btn-danger">삭제</button></a>
		
		<div class="comment">
			<span id="cmtWriter" >userNick</span>
			<textarea id="cmtText" placeholder="댓글을 남겨보세요"></textarea>
			<div class="cbtn">
			<button type="button" class="btn btn-success" id="cmtBtn">등록</button>
			</div>
		</div>
		
		<ul class="list-group list-group-flush" id="cmtListArea">
	 	 <li class="list-group-item">
	  		<div class="ms-2 me-auto">
	  			 <div class="fw-bold">writer</div>
		     	 Content
	  		</div>
		    <span class="badge text-bg-primary rounded-pill">regDate</span>
	 	 </li>	 
		</ul>
		
		<br>
		<div>
		<button type="button" id="moreBtn" data-page="1" class="btn btn-dark" style="visibility: hidden">MORE +</button>
		</div>
		
		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h1 class="modal-title fs-5" id="cmtWriterMod">글쓴이</h1>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		      	<input type="text" class="form-control" id="cmtTextMod">
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
		        <button type="button" id="cmtModBtn" class="btn btn-primary">수정</button>
		      </div>
		    </div>
		  </div>
		</div>
		
	<script type="text/javascript">
	let bnoVal = `<c:out value ="${bvo.bno}" />`;
	console.log(bnoVal);
	</script>
	
	<script type="text/javascript" src="/resources/js/boardDetailComment.js"></script>
		
	<script type="text/javascript">
		spreadCommentList(bnoVal);
	</script>

	</div>

<jsp:include page="../layout/footer.jsp" />