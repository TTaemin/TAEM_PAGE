<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="../include/header.jsp" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>멤버 정보</title>

</head>
<body>
	
	<div class="super_container">
	
		<div class="all_container">
		
			<div>
				
				<h1>MY INFO</h1>
					
					<div>
						<label>ID</label><br>
						<p>${member.memId }</p>
					</div>	
					
					<hr>
					
					<div>
						<label>이름</label>
						<br>
						<p>${member.memName }</p>
					</div>	
					
					<hr>
					
					<div>
						<label>비밀번호</label><br>
						<p>비밀번호 수정을 원하시면 정보수정버틀을 눌러주세요.</p>
					</div>	
					
					<hr>
					
					<div>
						<label>이메일</label><br>
						<p>${member.memEmail }</p><br>
					</div>
					
					<hr>
					
					<div>
						<label>전화번호</label><br>
						<p>${member.memName }</p><br>						
					</div>
					
					<hr>	
					
					<div>
						<label>가입일</label><br>
						<p><fmt:formatDate value="${member.joinDate }" pattern="yyyy. MM. dd"/></p><br>
					</div>
					
					<hr>
					<br>
							
			</div>
			
			<div>
				<button type="button" id="btn-memUpd">정보수정</button>
			</div>
			
			<div>
				<button type="button" id="btn-memDel">회원탈퇴</button>
			</div>
			
			<hr>
			<br>
		
		</div>
		
		<script>
			$("#btn-memUpd").click(function(){
				location.href="${pageContext.request.contextPath}/member/password";
			});
			
			$("#btn-memDel").click(function(){
				var memNo = "${member.memNo}";
				location.href="${pageContext.request.contextPath}/member/delete?no=" + memNo;
			});
		</script>
	
	
	</div>
	

</body>
</html>