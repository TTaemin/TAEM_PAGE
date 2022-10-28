<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/styles/main_styles.css'/>">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Header</title>
</head>
<body>
	
	<div class="super_container">
	
		<header class="header">
		
			<div class="main_logo">
				<a href="<c:url value='/'/>">
					<img src="<c:url value='/resources/images/taem.png' />"/>
				</a>
			</div>
		
			<nav class="header_nav">
								
				<ul class="board_category">
					<li class="board">
						<a href="#">BOARD
							<i class="fa fa-angle-down"></i>
						</a>
						
						<ul class="board_selection">
							<li><a href="<c:url value="/board/list?cate=100"/>">INTRODUCE</a></li>
							<li><a href="<c:url value="/board/list?cate=200"/>">PORTFORLIO</a></li>
							<li><a href="<c:url value="/board/list?cate=300"/>">LOG</a></li>
							<li><a href="<c:url value="/board/list?cate=400"/>">TRAVEL</a></li>
							<li><a href="<c:url value="/board/list?cate=500"/>">RANDOM</a></li>
						</ul>
					</li>
				</ul>
				
				<ul class="letter">
					<li><a href="<c:url value='/letter/list'/>">LETTER</a></li>
				</ul>
			
				<ul class="login">
					<!-- 로그인/로그아웃 -->
					<li>
						<c:if test="${member == null }">
							<a href="<c:url value='/member/login'/>">로그인</a> 
						</c:if>
						
						<c:if test="${member != null }">
							<a href="<c:url value='/member/logout'/>">로그아웃</a>
						</c:if>
					</li>
					
				</ul>
					
				<ul class="mypage">
					<!-- admin페이지/마이페이지 -->
					<li>
						<c:if test="${member.verify == 7 }">
							<a href="<c:url value='/admin/main_page'/>"> 탬 </a>
						</c:if>
						
						<c:if test="${member.verify != 7 }">
							<a href="<c:url value='/member/info'/>"> MY </a>
						</c:if>
					</li>
				
				</ul>
			
				
			</nav>
			

			
		</header>
	
	</div>

</body>
</html>