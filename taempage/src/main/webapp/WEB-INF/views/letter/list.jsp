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
<title>Letter List</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/styles/main_styles.css'/>">
</head>
<body>

	<div class="super_container">
	
		<div class="all_container">
		
			<div class="list_top">
				
				<div class="criteria_top">
					<div class="page_box">
						<!-- perPageNum의 값을 정하는 select 박스 -->
						<select class="form-control" id="perPageSel">
					  		<option value="10">10</option>
					  		<option value="20">20</option>
					  		<option value="30">30</option>
						</select>
					</div>
				</div>
			
			</div>


			<br>
			
			<div class="letter_list_container">
				
				<table class="letter_list">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
						</tr>
					</thead>
					
					<tbody>
					<c:forEach items="${letter}" var="letter">
						<tr>
							<td>${letter.letterNo}</td>
							<td>
								<c:choose>
									<c:when test="${letter.memNo eq member.memNo || member.verify eq '7' }">
										<a href="${pageContext.request.contextPath}/letter/view?no=${letter.letterNo}"><c:out value="${letter.lTitle}"/></a>
									</c:when>
									<c:otherwise>
									<img src="${pageContext.request.contextPath}/images/lock_icon.png" style="width:10px; height:10px;" alt="비밀글" />
									방명록은 작성자와 관리자만 볼 수 있습니다.
									</c:otherwise>
								</c:choose>
							</td>
							<td>${letter.memId}</td>
							<td><fmt:formatDate value="${letter.letterDate}" pattern="yyyy. MM. dd" /></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				
			</div>
		
			<div class="btn">
				<a href="${pageContext.request.contextPath}/letter/write">글쓰기</a>
			</div>
			
			
			<hr>
			<br>
		
		
			<!-- 페이지 번호 -->	
			<div class="criteria_bottom">
				<ul class="pagination">
				
					<!-- prev 버튼 -->
					<li id="page-prev">
						<a href="list${lPageMaker.makeQuery(lPageMaker.startPage-1)}" aria-label="Prev">
							<span aria-hidden="true">«</span>
						</a>
					</li>
					
					<!-- 페이지 번호 (시작 페이지 번호부터 끝 페이지 번호까지) -->
					<c:forEach begin="${lPageMaker.startPage}" end="${lPageMaker.endPage}" var="idx">
					    <li id="page${idx}">
						    <a href="list${lPageMaker.makeQuery(idx)}">${idx}</a>
					    </li>
					</c:forEach>
					
					<!-- next 버튼 -->
					<li id="page-next">
					    <a href="list${lPageMaker.makeQuery(lPageMaker.endPage + 1)}" aria-label="Next">
					    	<span aria-hidden="true">»</span>
					    </a>
					</li>
					
				</ul>
			</div>
			
			
			
		
		</div>
	
	</div>
	
	
	<script>
		$(function(){
			//perPageNum select 박스 설정
			setPerPageNumSelect();

			//prev 버튼 활성화, 비활성화 처리
			var canPrev = '${lPageMaker.prev}';
			if(canPrev !== 'true'){
				$('#page-prev').addClass('disabled');
			}
			
			//next 버튼 활성화, 비활성화 처리
			var canNext = '${lPageMaker.next}';
			if(canNext !== 'true'){
				$('#page-next').addClass('disabled');
			}
			
			//현재 페이지 파란색으로 활성화
			var thisPage = '${lPageMaker.lCri.page}';
			//매번 refresh 되므로 다른 페이지 removeClass 할 필요는 없음->Ajax 이용시엔 해야함
			$('#page'+thisPage).addClass('active');
		});
		
		function setPerPageNumSelect(){
			var perPageNum = "${lPageMaker.lCri.perPageNum}";
			var $perPageSel = $('#perPageSel');
			var thisPage = '${lPageMaker.lCri.page}';
			$perPageSel.val(perPageNum).prop("selected",true);
			//PerPageNum가 바뀌면 링크 이동
			$perPageSel.on('change',function(){
				//pageMarker.makeQuery 사용 못하는 이유: makeQuery는 page만을 매개변수로 받기에 변경된 perPageNum을 반영못함
				window.location.href = "list?page="+thisPage+"&perPageNum="+$perPageSel.val();
			});
		}
		
	</script>

</body>
</html>


<jsp:include page="../include/footer.jsp" />
