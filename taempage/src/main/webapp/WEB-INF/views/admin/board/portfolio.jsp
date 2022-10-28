<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="../../include/header.jsp" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>(admin) 보드리스트 - portfolio </title>
</head>
<body>
	
	<div class="super container">

		<div class="all_container">
		
			<div>
			
				<table>
					<thead>
						<tr>
							<th>체크박스</th>
							<th>번호</th>
							<th>카테고리</th>
							<th>제목</th>
							<th>비밀글</th>
							<th>작성일</th>
						</tr>
					</thead>
					
					<tbody>
						<tr>
							<td>체크박스</td>
							<td>${board.boardNo }</td>
							<td>${board.cateName }</td>
							<td><a href="${pageContext.request.contextPath}/board/view?no=${board.boardNo}">${board.title }</a></td>
							<td>${board.open }</td>
							<td><fmt:formatDate value="${board.boardDate}" pattern="yyyy. MM. dd" /></td>
						</tr>
					</tbody>
				</table>
			
			</div>
			
		</div>
		
	</div>
	

</body>
</html>