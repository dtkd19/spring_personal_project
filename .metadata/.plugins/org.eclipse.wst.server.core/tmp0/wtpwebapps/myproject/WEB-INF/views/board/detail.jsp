<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<link href="../resources/css/detail.css" rel="stylesheet"/>

<jsp:include page="../layout/header.jsp" />
	
	<sec:authentication property="principal.uvo" var="uvo"/>
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
				<span class="badge text-bg-info"> 댓글 ${bvo.cmtQty }</span>
				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-suit-heart heart" viewBox="0 0 16 16" role="button" id="heart">
				  <path d="m8 6.236-.894-1.789c-.222-.443-.607-1.08-1.152-1.595C5.418 2.345 4.776 2 4 2 2.324 2 1 3.326 1 4.92c0 1.211.554 2.066 1.868 3.37.337.334.721.695 1.146 1.093C5.122 10.423 6.5 11.717 8 13.447c1.5-1.73 2.878-3.024 3.986-4.064.425-.398.81-.76 1.146-1.093C14.446 6.986 15 6.131 15 4.92 15 3.326 13.676 2 12 2c-.777 0-1.418.345-1.954.852-.545.515-.93 1.152-1.152 1.595zm.392 8.292a.513.513 0 0 1-.784 0c-1.601-1.902-3.05-3.262-4.243-4.381C1.3 8.208 0 6.989 0 4.92 0 2.755 1.79 1 4 1c1.6 0 2.719 1.05 3.404 2.008.26.365.458.716.596.992a7.6 7.6 0 0 1 .596-.992C9.281 2.049 10.4 1 12 1c2.21 0 4 1.755 4 3.92 0 2.069-1.3 3.288-3.365 5.227-1.193 1.12-2.642 2.48-4.243 4.38z"/>
				</svg> ${bvo.likeCount }		
				</div>
			</div>	
		</div>
		<div class="conBox1">
		<c:set value="${bdto.flist }" var="flist"></c:set>
		<div class="dcontent" style="padding: 20px">
			<c:forEach items="${flist }" var="fvo">
				 <li class="list-group-item">
			  		<c:choose>
			  			<c:when test="${fvo.fileType > 0 }">
			  				<div style="margin-bottom: 10px">
			  					<img alt="" src="/upload/${fvo.saveDir }/${fvo.uuid}_${fvo.fileName}">
			  				</div>
					  	<%-- 	<span class="badge text-bg-info rounded-pill">${fvo.regDate }</span> --%>
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
		</div>
		<div style="margin-bottom: 30px">
		<a href="/board/modify?bno=${bvo.bno }"><button type="button" class="btn btn-primary">수정</button></a>
		<a href="/board/delete?bno=${bvo.bno }"><button type="button" class="btn btn-danger">삭제</button></a>
		</div>
		<!-- 댓글 -->
		<sec:authentication property="principal.uvo.authList" var="auths"/>
		<div class="comment">
			<span id="cmtWriter" >
				<sec:authentication property="principal.uvo.nickName" var="authNick"/>${authNick }</span>
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
	
	<script type="text/javascript">
	let authNick = `<c:out value ="${authNick}" />`;
	console.log(authNick);
	</script>
	
	<script type="text/javascript">
	let admin =  `<c:out value ="${auths.stream().anyMatch(authVO -> authVO.auth.equals('ROLE_ADMIN')).get()}" />`;  
	console.log(admin);
	</script>
	
	<script type="text/javascript">
	let emailVal = `<c:out value ="${uvo.email}" />`; 
	console.log(emailVal);
	</script>
	
	<script type="text/javascript" src="/resources/js/boardDetailComment.js"></script>
		

	<script type="text/javascript" src="/resources/js/like.js"></script>

	<script type="text/javascript">
		spreadCommentList(bnoVal);
	</script>
	
	<script type="text/javascript">
		printLikeBox(bnoVal,emailVal);
	</script>

	</div>

<jsp:include page="../layout/footer.jsp" />