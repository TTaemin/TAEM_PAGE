<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="../include/header.jsp" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Board List</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/styles/main_styles.css'/>">
</head>
<body>

	<div class="super_container">
	
		<div class="all_container">

			<div class="title">
				<a href="${pageContext.request.contextPath}/board/introduce">INTRODUCE</a>
			</div>
			
			<div class="category">
				<jsp:include page="../board/list/category.jsp" />
			</div>
			
			<div class="criteria_top">
				<jsp:include page="../board/list/cri_t.jsp" />
			</div>
			
			<div class="body">
				<jsp:include page="../board/list/body.jsp" />
			</div>
			
			<div class="criteria_bottom">
				<jsp:include page="../board/list/cri_b.jsp" />
			</div>
						
		</div>
		
	</div>

</body>
</html>


<jsp:include page="../include/footer.jsp" />