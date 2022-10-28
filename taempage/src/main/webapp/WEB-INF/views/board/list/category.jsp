<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" type="text/css" href="<c:url value='/styles/main_styles.css'/>">
<style>
.category
{
	width: 100%;
	margin: 0 auto;
	background: #47a97a;
}
.category p
{
	font-weight: 700;
	font-size: x-large;
	text-align: center;
}
.board_category
{
	float:left; 
	width: 100%;
	margin: 0 auto;
	background: #47a97a;
}
.board_category li
{

	display: inline-block;
	text-align: center;
	font-weight: 400;
	font-size: medium;
}
</style>
<div class="category">
	<p>CATEGORY</p>

	<ul class="board_category">
			
		<li><a href="<c:url value="/board/list?cate=100"/>">INTRODUCE</a></li>
		<li><a href="<c:url value="/board/list?cate=200"/>">PORTFORLIO</a></li>
		<li><a href="<c:url value="/board/list?cate=300"/>">LOG</a></li>
		<li><a href="<c:url value="/board/list?cate=400"/>">TAVEL</a></li>
		<li><a href="<c:url value="/board/list?cate=500"/>">RANDOM</a></li>
		
	</ul>
</div>

