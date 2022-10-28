<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../include/header.jsp" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<title>Member-Login</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/styles/main_styles.css'/>">

</head>
<body>

	<div class="super_container">
		
		<div class="all_container">
		
			<div class="title">
				<h1>로그인</h1>
			</div>
			
			<br>
			
			<div class="login">
			<form action="${pageContext.request.contextPath}/member/login" method="post">
			
				<c:if test="${member == null }">
					
					<div>
						<label>아이디</label> &nbsp;&nbsp;
						<input type="text" name="memId" id="memId" required="required">
					</div>
					
					<br>
					
					<div>
						<label>비밀번호</label> &nbsp;&nbsp;
						<input type="password" name="memPw" id="memPw" required="required">
					</div>
					
					<br>
					
					<div>
						<input type="checkbox" value="idSave">아이디 저장
					</div>
					
					<br>
					
					<div>
						<a href="<c:url value='/member/search'/>">아이디/비밀번호 찾기</a>
					</div>
					
					<br>
					
					<div class="btn"><input type="submit" id="btn-submit" value="로그인" style="background-color: transparent; color: #400040; border: 0px transparent solid;"/></div> &nbsp;&nbsp;
					<div class="btn"><a href='<c:url value="/member/join"/>'>회원가입</a></div>
					
				</c:if>
				
				<br>
				
				<c:if test="${msg == false}">
					<p style="color: red;">로그인 실패! 아이디와 비밀번호 확인해주세요.</p>
				</c:if>
				
				<c:if test="${member != null }">
					<div>
						<p>${member.memId}님 환영 합니다.</p>
						<br>
						
						<div class="btn">
							<a href='<c:url value="/"/>'>홈으로 가기</a>
						</div>
						<div class="btn">	
							<a href='<c:url value="/member/logout"/>'>로그아웃</a>
						</div>
						
					</div>
				</c:if>
			
			</form>
			</div>
		
		</div>
		
	</div>

</body>
</html>