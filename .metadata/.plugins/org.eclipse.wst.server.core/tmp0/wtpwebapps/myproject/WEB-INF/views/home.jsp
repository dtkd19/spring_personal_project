<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page session="false" %>
<link href="../resources/css/main.css" rel="stylesheet"/>

<jsp:include page="layout/header.jsp"/>

<div class="container-md mainC">


<div class="cont">


</div>


<sec:authorize access="isAuthenticated()">
<sec:authentication property="principal.uvo.nickName" var="authNick"/>
<div class="startMsg">
<h1> <strong>${authNick } </strong> 님 어서오세요~ </h1>
<span>우주에 관하여 자유롭게 의견을 공유해봐요!!</span>
</div>
</sec:authorize>

<div class="mainMsg">
<p> 우주란 무엇입니까? </p>
<span>
우주는 공기가 전혀 없는 거의 완벽한 진공입니다. 그것은 비어있지 않습니다: 그것은 많은 형태의 방사선뿐만 아니라 가스, 먼지, 그리고 빈 공간 주변에 떠다니는 다른 물질들을 포함합니다.
지구에서, 우리는 우리의 행성으로부터 어느 방향으로든 465억 광년 이내에 있는 행성, 별, 그리고 은하를 관찰할 수 있습니다. 이 우주의 영역은 관측 가능한 우주라고 불립니다. 우주의 추정 나이는 114억 년에서 138억 년 사이입니다.
</span>
<p> 우주는 어디서 시작합니까? </p>
<span>
지구와 결합된 우리의 관점에서 볼 때, 우주는 지구와 우주를 분리하는 경계 밖에 있는 모든 것입니다.
정확히 외부 우주가 어디서 시작되는지에 대한 다른 정의가 있습니다. 가장 널리 사용되는 경계는 카르만의 선으로, 평균 해수면에서 100km 위에 위치합니다. 이 표시부터 공기가 너무 얇아져서 일반 항공기가 날 수 없습니다.
</span>
<p> 우주 지역 </p>
<span>
외부 우주는 여러 지역으로 나눌 수 있습니다. 이들은 그들 내에서 우세한 자기장과 "바람"에 의해 결정됩니다. <br>

지구 궤도 주변의 외부 우주를 지구 궤도 주변 우주라고 합니다. 이는 지구 상층 대기와 지구 자기장의 최외곽 지역 사이에 위치합니다. <br>
태양계 내부의 외부 우주를 행성간 우주라고 합니다. 이는 태양풍에 의해 정의되며, 태양과 그 행성들을 둘러싸는 거대한 "버블"인 헬리오스페어를 형성합니다. 헬리오파우즈(헬리오스페어의 최외곽)에서, 이는 성간 우주로 이어집니다. <br>
성간 우주는 은하계 내 별계간 물리적 공간이고, 이는 가스와 먼지로 이루어진 성간 매질(ISM)로 채워져 있습니다.  <br>
은하간 우주는 은하 간 물리적 공간이고, 이는 일반적으로 먼지와 파편이 없기 때문에 거의 진공에 가깝습니다.
</span>

<p> 우주는 어떤 물질로 이루어져 있을까요? </p>
<span>
과학자들은 우주가 세 가지 유형의 물질로 이루어져 있다고 생각합니다: 보통 물질, 어두운 물질, 그리고 어두운 에너지입니다
세가지 물질이 무엇인지 궁금하다면, 더 다양한 정보를 보고싶다면 게시판에서 서로 정보를 공유해보세요!!!
</span>


</div>


</div>






<script>
	let modify_msg = `<c:out value="${modify_msg}" />`;
	console.log(modify_msg);
	
	if(modify_msg == 'ok'){
		alert("회원정보가 수정되었습니다. 다시로그인해주세요.");
	}
	if(modify_msg == 'fail'){
		alert("회원정보수정이 실패되었습니다. 다시시도해주세요.");
	}
	
	let remove_msg = `<c:out value="${remove_msg}" />`;
	console.log(remove_msg);
	
	if(remove_msg == 'ok'){
		alert("회원 탈퇴가 완료되었습니다. 안녕히가세요.");
	}
	if(remove_msg == 'fail'){
		alert("회원탈퇴가 실패되었습니다. 다시시도해주세요.");
	}
</script>


<jsp:include page="layout/footer.jsp"/>
