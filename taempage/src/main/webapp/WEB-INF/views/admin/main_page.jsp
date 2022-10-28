<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../include/header.jsp" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main_page</title>
</head>
<body>

	<div class="super_container">
	
		<div class="all_container">
		
			<div>
				<a href="${pageContext.request.contextPath}/admin/user/list">멤버리스트</a>
			</div>
			
			<div>
				<a href="${pageContext.request.contextPath}/admin/board/list">보드리스트</a>
			</div>
			
			<div>
				<a href="${pageContext.request.contextPath}/board/write">보드 글 작성</a>
			</div>
			

		
		</div>
	
	</div>

</body>
</html>