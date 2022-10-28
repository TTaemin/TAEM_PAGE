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

<script>
	function fn_newPw(){
		$("#newPw").css('display', 'inline-block');
	}
</script>

</head>
<body>
	
	<div class="super_container">
	
		<div class="all_container">
		<form action="${pageContext.request.contextPath}/member/update" method="post">
		<input type="hidden" name="memNo" value="${member.memNo }">
			<div>
				
				<h1>정보 수정</h1>
					
					<div>
						<label>ID</label><br>
						<input type="text" id="memId" name="memId" value="${member.memID }" readonly="readonly">
					</div>	
					
					<hr>
					
					<div>
						<label>이름</label><br>
						<input type="text" id="memName" name="memName" value="${member.memName }" readonly="readonly">
					</div>	
					
					<hr>
					
					<div>
						<label>비밀번호</label><br>
						<div id="newPw" style="display:none;">
							<input type="Password" name="memPw" id="memPw" placeholder="새로운 비밀번호를 입력하세요." max="20" required="required">
						</div>
						<button type="button" id="changePw" onclick="fn_newPw()">비밀번호 변경</button>
					</div>	
					
					<hr>
					
					<div>
						<label>이메일</label><br>
						<input type="text" id="memEmail" name="memEmail" value="${member.memEmail }" required="required">
					</div>
					
					<hr>
					
					<div>
						<label>전화번호</label><br>
						<input type="text" id="memPhone" name="memPhone" value="${member.memPhone }" required="required">
					</div>
					
					<hr>	
					
					<div>
						<label>가입일</label><br>
						<fmt:formatDate value="${member.joinDate }" pattern="yyyy. MM. dd"/>
					</div>
					
					<hr>
					<br>
							
			</div>
			
			<div class="form-group has-feedback" align="right">
			
				<button type="submit">수정</button>	
				<button type="button" id="btn-memDel" onclick="location.href='${pageContext.request.contextPath}/member/delete'">탈퇴하기</button>
				
			</div>
			
			<div>
				<c:if test="${msg == false}">
					비밀번호가 맞지 않습니다.
				</c:if>
			</div>
			
			
		</form>
		</div>
	
	</div>
	

</body>
</html>