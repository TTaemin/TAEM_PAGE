<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../../include/header.jsp" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<title>(admin) 글 리스트</title>
</head>
<body>

	<div class="super_container">
	
		<div class="all_container">
		
			<div>
				<a href="<c:url value="/admin/board/list"/>">리스트</a>
			</div>
			
			
			<hr>
		
		
			<div>
				<a href="<c:url value="/admin/board/introduce"/>">INTRODUCE</a>
			</div>
			
			<div>
				<a href="<c:url value="/admin/board/portfolio"/>">PORTFOLIO</a>
			</div>
			
			<div>
				<a href="<c:url value="/admin/board/log"/>">LOG</a>
			</div>
			
			<div>
				<a href="<c:url value="/admin/board/travel"/>">TAVEL</a>
			</div>
			
			<div>
				<a href="<c:url value="/admin/board/random"/>">RANDOM</a>
			</div>
			
		
		</div>
	
	</div>

</body>
</html>