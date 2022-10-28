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

<title>글 작성 완료</title>
</head>
<body>

	<div class="super container">
	
		<div class="all_container">
		
			<div>
			
				<h1>
					글 작성이 완료 되었습니다~!
				</h1>
				
				<br>
				
				<div><a href="<c:url value='/'/>">메인</a> 으로 가기</div>
				
				<br>
				
				
				<div><ul class="board_category">
					<li class="board">
						<a href="#">글리스트
							<i class="fa fa-angle-down"></i>
						</a>
						
						<ul class="board_selection">
							<li><a href="<c:url value="/board/list?cate=100"/>">INTRODUCE</a></li>
							<li><a href="<c:url value="/board/list?cate=200"/>">PORTFORLIO</a></li>
							<li><a href="<c:url value="/board/list?cate=300"/>">LOG</a></li>
							<li><a href="<c:url value="/board/list?cate=400"/>">TRAVEL</a></li>
							<li><a href="<c:url value="/board/list?cate=500"/>">RANDOM</a></li>
						</ul>
					</li> 로 가기
				</ul></div>
				
				<br>
			
			</div>
		
		</div>
	
	</div>

</body>
</html>