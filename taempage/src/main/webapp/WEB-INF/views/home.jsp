<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<jsp:include page="./include/header.jsp" />


<html>
<head>
<meta charset="utf-8">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Home</title>

</head>
<style>
@import url('https://fonts.googleapis.com/css2?family=Gugi&family=Sedgwick+Ave&display=swap');

.welcome_page
{
	
	height: 300px;
	width: 100%;
	background: #d1d1c0;
	
}
.welcome_page h1
{
	font-family: 'Gugi', 'Sedgwick Ave';
	padding: 70px;
	font-weight: 400;
	font-size: 40px;
	text-align: center;
	color: #435c27;
	
}
.welcome_page h2
{
	font-family: 'Gugi', 'Sedgwick Ave';
	font-weight: 400;
	font-size: 40px;
	text-align: center;
	color: #435c27;
	
}
.main_page
{
	height: 100%;
	width: 100%;
	background: #ffc286;
}
.main_page img
{
	height: 100%;
	width: 100%;
	align-items: center;
}
</style>
<body>
	
	<div class="super_container">
	
		<div class="all_container">
		
			<div class="main_page">
				<img src="<c:url value='/images/main.png'/>">
			</div>
		
		
			<div class="welcome_page">
				<h1>
					This is Taem-Page, Welcome!
				</h1>
				
				<br>
				
				<h2>
					탬페이지에 오신걸 환영합니다~!
				</h2>
			</div>

			<hr>

		</div>
	
	</div>

</body>
</html>


<jsp:include page="./include/footer.jsp" />
