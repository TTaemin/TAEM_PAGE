<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="../include/header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Password</title>
</head>
<body>

	<div class="super_container">
	
		<div class="all_container">
		
			<div>
		 
				비밀번호를 입력해 주세요.
		
				<input type="hidden" id="letterNo" name="letterNo" value="${letter.letterNo }">
				<input type="hidden" id="lPassword" name="lPassword" value="${letter.lPassword }">
				<input type="password" id="password" max="4" placeholder="비밀번호" required="required">
		
				
				<button type="button" id="btn-pwChk">확인</button>
				
		
				
				<script>
					$("#btn-pwChk").click(function() {
						var letterNo = $('#letterNo').val();
						var lPw = $('#lPassword').val();
						var pw = $('#password').val();
						
						if(pw != ""){
							if(lPw == pw){
								
								location.href="${pageContext.request.contextPath}/letter/update?no=" + letterNo;
							}else{
								alert("비밀번호가 일치하지 않습니다.");
								return false;
							}
						}else{
							alert("비밀번호를 입력하세요.");
							return false;
						}
					});
				</script>
				<!-- chk.qnaPw == pw 하려면 mapper 바꿔야함 카운트가 아니라 데이터 가져와야함 (수정필요) 아니면 chk == "1" 이런식으로 해야함 -->
				
				
			</div>
	
	
		</div>
	</div>
</body>
</html>