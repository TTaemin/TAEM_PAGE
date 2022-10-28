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
<title>회원탈퇴</title>

</head>
<body>

	<div class="super_container">
	
		<div class="all_container">

			<div>
			<form id="delForm" action="${pageContext.request.contextPath}/member/delete" method="post">
			
			<input type="hidden" name="memNo" value="${member.memNo }"/>
			
				<table>
					<tr>
						<td>
							<label for="id">아이디</label>
							<input type="text" id="memId" name="memId" value="${member.memId}" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td>
							<label for="userName">성명</label>
							<input type="text" id="memName" name="memName" value="${member.memName}" readonly="readonly"/>
						</td>
					</tr>
					<tr>	
						<td>
							<label for="password">비밀번호</label>
							<input type="password" name="memPw" id="memPw" placeholder="비밀번호" max="20" style="width: 100%">
							</td>
					</tr>
					<tr>
						<td><button class="btn-success" type="submit" id="submit">회원탈퇴</button></td>
						<td><button class="btn-cancle" type="button" id="cancel">취소</button></td>
					</tr>
				</table>
				
			</form>	
			</div>
		
			<div>
				<c:if test="${msg == false}">
					<p style="color: red;"> 비밀번호가 일치하지 않습니다. </p>
				</c:if>
			</div>
			
		</div>
		
		<script>
			$(document).ready(function(){
				$(".cancel").on("click", function(){
					location.href="/";
				});
				
				$("#submit").on("click", function(){
					if($("#memPw").val()==""){
						alert("비밀번호를 입력하세요.");
						$("#memPw").focus();
						return false;
					}
				});
			});
		</script>
		
	</div>

</body>
</html>