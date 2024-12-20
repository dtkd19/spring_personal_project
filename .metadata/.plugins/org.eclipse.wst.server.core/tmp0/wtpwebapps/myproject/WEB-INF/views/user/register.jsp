<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="../resources/css/login.css" rel="stylesheet"/>
<jsp:include page="../layout/header.jsp" />

<div class="container-md">

	<div class="container">
		<div class="row">
			<div class="col-lg-3 col-md-2"></div>
			<div class="col-lg-6 col-md-8 login-box">
				<div class="col-lg-12 login-key">
					<i class="fa fa-key" aria-hidden="true"></i>
				</div>
				<div class="col-lg-12 login-title">회원가입</div>

				<div class="col-lg-12 login-form">
					<div class="col-lg-12 login-form">
						<form action="/user/register" method="post">
						
							<div class="form-group">
								<label class="form-control-label">별명</label> 
								<input type="text" class="form-control" name="nickName">
							</div>
							<div class="form-group">
								<label class="form-control-label">이메일</label> 
								<input type="text" class="form-control" name="email">
							</div>
							<div class="form-group">
								<label class="form-control-label">비밀번호</label>
								<input type="password" class="form-control" name="pwd">
							</div>
							<div class="col-lg-12 loginbttm">
								<div class="col-lg-6 login-btm login-text">
									<!-- Error Message -->
								</div>
								<div class="col-lg-6 login-btm login-button sBtn">
									<button type="submit" class="btn btn-outline-primary">회원가입</button>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="col-lg-3 col-md-2"></div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="../layout/footer.jsp" />