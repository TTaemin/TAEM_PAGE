<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="../include/header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Letter Delete</title>
</head>
<body>

	<div class="super_container">
	
		<div class="all_container">
		
			<div id="letterDel">
				<form action="${pageContext.request.contextPath}/letter/delete?no=${letter.letterNo}" method="post">
				<input type="hidden" id="letterNo" name="letterNo" value="${letter.letterNo}">
				<input type="hidden" id="lPassword" name="lPassword" value="${letter.lPassword}">
				
				<p>비밀번호를 입력하세요.</p>
				<input type="password" id="password" placeholder="비밀번호" required="required">
				
				<div>	
					<button type="submit" id="btn-del">삭제</button>
					<a href="${pageContext.request.contextPath}/letter/view?no=${letter.letterNo}"><input type="button" value="취소"></input></a>
				</div>
				
				</form>
			</div>
		
			<script>
				$("#btn-del").click(function() {
					var letterNo = $('#letterNo').val();
					var lPw = $('#lPassword').val();
					var pw = $('#password').val();
					
					
					if(pw != ""){
						if(lPw == pw){
							alert("삭제되었습니다");
							location.href="${pageContext.request.contextPath}/letter/list";
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
		
		</div>
		
	</div>

</body>
</html>