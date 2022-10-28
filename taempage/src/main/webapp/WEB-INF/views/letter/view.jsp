<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="../include/header.jsp" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Letter View</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/styles/main_styles.css'/>">

</head>
<body>

	<div class="super_container">
	
		<div class="all_container">
		
		<h2>글 상세보기</h2>
		
		<br>
		
			<div class="letter_view">
			
				<div>
					<h2>${letter.lTitle}</h2>
				</div>
				
				<hr>
				
				<div>
					<h4>작성자</h4> <p>${letter.memId }</p>
				</div>
				
				<hr>
				
				<div>
					<p><fmt:formatDate value="${letter.letterDate}" pattern="yyyy. MM. dd" /></p>
				</div>
				
				<hr>
				<br>
				
				<div>
					<p>${letter.lContent }</p>
				</div>
				
				<hr>
				<br>
						
			</div>
			
			<div class="btn">
				<a href="${pageContext.request.contextPath}/letter/list">목록</a>
			</div>
			
			<div class="btn">
				<a href="${pageContext.request.contextPath}/letter/password?no=${letter.letterNo}" id="lettterUpd">수정</a>
			</div>
			
			<div class="btn">
				<a href="${pageContext.request.contextPath}/letter/delete?no=${letter.letterNo}" id="lettterDel">삭제</a>
				
				
			</div>

		</div>
	
	</div>

</body>
</html>


<jsp:include page="../include/footer.jsp" />

