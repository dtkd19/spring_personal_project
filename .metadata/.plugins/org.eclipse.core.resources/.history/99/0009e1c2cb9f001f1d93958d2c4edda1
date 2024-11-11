<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../layout/header.jsp" />
<link href="../resources/css/list.css" rel="stylesheet"/>
	<div class="container-md">
	<h3>자유게시판</h3>	
	<!-- serach -->
	<div class ="container-fluid" >
	    <form action="/board/list" class="d-flex" role="search" >
	      <select class="form-select" name="type" id="inputGroupSelect01" style="width: 70%; margin-right: 20px ">
		    <option ${ph.pgvo.type == null ? 'selected' : ''  }>분류선택</option>
		    <option value="t" ${ph.pgvo.type eq 't' ? 'selected' : ''  }>제목</option>
		    <option value="w" ${ph.pgvo.type eq 'w' ? 'selected' : ''  }>글쓴이</option>
		    <option value="c" ${ph.pgvo.type eq 'c' ? 'selected' : ''  }>내용</option>
		    <option value="tw"${ph.pgvo.type eq 'tw' ? 'selected' : ''  } >제목 + 글쓴이</option>
		    <option value="wc"${ph.pgvo.type eq 'wc' ? 'selected' : ''  }>글쓴이 + 내용</option>
		    <option value="tc"${ph.pgvo.type eq 'tc' ? 'selected' : ''  }>제목 + 내용</option>
		    <option value="twc"${ph.pgvo.type eq 'twc' ? 'selected' : ''  }>전체</option>
		  </select>
	    
	        <input class="form-control me-2" name="keyword" type="search" placeholder="검색내용입력..." aria-label="Search" value="${ph.pgvo.keyword }">
	        <input type="hidden" name="pageNo" value="1">
	        <input type="hidden" name="qty" value="${ph.pgvo.qty }">
	       <!--  <button class="btn btn-outline-success" type="submit">Search</button> -->
	       <button type="submit" class="btn btn-secondary position-relative">
	 		 Search
	 		<span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
	    	${ph.totalCount }
	    	<span class="visually-hidden">unread messages</span> </span>
			</button>    
      </form>
	</div>
	<div class="sortBtn">
	<a href="/board/sortCmt"><button class="btn btn-outline-info">댓글 TOP10</button></a>
	<a href="/board/sortRead"><button class="btn btn-outline-info">조회 TOP10</button></a>	
	</div>
	<div class="tableBox">
	<table class="table table-hover">
		<thead>
			<tr>
				<th scope="col">번호</th>
				<th scope="col">제목</th>
				<th scope="col">글쓴이</th>
				<th scope="col">작성일</th>
				<th scope="col">조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="bvo">
				<tr>
					<td>${bvo.bno }</td>
					<td><a href="/board/detail?bno=${bvo.bno } ">${bvo.title }</a>
					<c:if test="${bvo.hasFile > 0 }"> 
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-link-45deg" viewBox="0 0 16 16">
					  <path d="M4.715 6.542 3.343 7.914a3 3 0 1 0 4.243 4.243l1.828-1.829A3 3 0 0 0 8.586 5.5L8 6.086a1 1 0 0 0-.154.199 2 2 0 0 1 .861 3.337L6.88 11.45a2 2 0 1 1-2.83-2.83l.793-.792a4 4 0 0 1-.128-1.287z"/>
					  <path d="M6.586 4.672A3 3 0 0 0 7.414 9.5l.775-.776a2 2 0 0 1-.896-3.346L9.12 3.55a2 2 0 1 1 2.83 2.83l-.793.792c.112.42.155.855.128 1.287l1.372-1.372a3 3 0 1 0-4.243-4.243z"/>
					</svg>		
					</c:if> 
					<span style="color: red">[${bvo.cmtQty }]</span> 
					</td>
					<td>${bvo.writer } </td>
					<td>${bvo.regDate }</td>
					<td>${bvo.readCount}
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<div class="button-container">
	<a href="/board/register"><button type="button" class="btn btn-secondary">
	<svg xmlns="http://www.w3.org/2000/svg" width="18" height="20" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
	  <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
	  <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5z"/>
	</svg> <span class="writeBtn">글쓰기</span>
	</button></a>
	</div>
	<nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center">
			<li class="page-item ${ph.prev eq false ? 'disabled' : '' }"><a class="page-link" href="/board/list?pageNo=${ph.startPage-1 }&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}"
				aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
			</a></li>
			<c:forEach begin="${ph.startPage }" end="${ph.endPage }" var = "i">
			<li class="page-item ${ph.pgvo.pageNo eq i ? 'active' : '' } "><a class="page-link" href="/board/list?pageNo=${i } &qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}">${i }</a></li>
			</c:forEach>
			<li class="page-item ${ph.next eq false ? 'disabled' : '' }"><a class="page-link" href="/board/list?pageNo=${ph.endPage+1 }&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}"
				aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>
		</ul>
	</nav>


	</div>

<jsp:include page="../layout/footer.jsp" />