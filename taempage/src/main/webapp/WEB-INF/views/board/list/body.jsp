<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


			
<div class="board_list_container">
	
	<table class="board_list">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		
		<tbody>
		<c:forEach items="${bdList}" var="list">
			<tr>
				<td>${list.boardNo}</td>
				<td>
					<c:if test="${list.open eq 'N'}">
						<img src="${pageContext.request.contextPath}/images/lock_icon.png" style="width:10px; height:10px;" alt="비밀글" />
						<c:choose>
							<c:when test="${member.verify eq '7'}">
								<a href="${pageContext.request.contextPath}/board/view?no=${list.boardNo}"><c:out value="${list.title}"/></a>
							</c:when>
							<c:otherwise>비밀글은 관리자만 볼 수 있습니다.</c:otherwise>
						</c:choose>
					</c:if>
					<c:if test="${list.open eq 'Y'}">
						<a href="${pageContext.request.contextPath}/board/view?no=${list.boardNo}"><c:out value="${list.title}"/></a>
					</c:if>
				</td>
				<td><p>Alex</p></td>
				<td><fmt:formatDate value="${list.boardDate}" pattern="yyyy. MM. dd" /></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<br>
	
	<c:if test="${member.verify == 7}">
		<div class="btn">
		    <a href="${pageContext.request.contextPath}/board/write">글쓰기</a>
		</div>
	</c:if>

</div>
