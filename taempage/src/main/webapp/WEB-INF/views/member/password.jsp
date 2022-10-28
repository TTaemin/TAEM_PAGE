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
<title>정보수정-비밀번호입력창</title>
</head>
<body>
	
	<div class="super_container">
	
		<div class="all_container">
		
			<div id="pw">
			<form action="${pageContext.request.contextPath}/member/password" method="post">
				
				<h2>비밀번호를 입력해 주세요.</h2>
				
				<hr>
				
				<input type="hidden" name="memNo" id="memNo" value="${member.memNo }" />
				
				<label class="control-label" for="password">비밀번호</label>
				<input class="form-control" type="password" name="memPw" placeholder="비밀번호를 입력하세요." max="20" />
				
				<hr>
				
				<button type="submit" class="btn-success" id="submit">확인</button>
				<button type="button" class="btn-cancle" id="cancle">취소</button>
				
				<c:if test="${msg == false}">
					<p style="color: red;"> 비밀번호 불일치! </p>
				</c:if>
				
				<script>
					$(document).ready(function(){
						$("#cancle").click(function(){
							location.href="${pageContext.request.contextPath}/member/info";
						});
						
						$("#submit").click(function(){
							if($("#memPw").val()==""){
								alert("비밀번호를 입력하세요.");
								$("#memPw").focus();
								return false;
							}
						});
					});
				</script>
				
			</form>
			</div>
			
		</div>
		
	</div>

</body>
</html>