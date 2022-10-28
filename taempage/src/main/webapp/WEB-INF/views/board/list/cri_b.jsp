<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 페이지 번호 -->	
<div class="criteria_bottom">
	<ul class="pagination">
	
		<!-- prev 버튼 -->
		<li id="page-prev">
			<a href="list${pageMaker.makeQuery(pageMaker.startPage-1)}" aria-label="Prev">
				<span aria-hidden="true">«</span>
			</a>
		</li>
		
		<!-- 페이지 번호 (시작 페이지 번호부터 끝 페이지 번호까지) -->
		<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
		    <li id="page${idx}">
			    <a href="list${pageMaker.makeQuery(idx)}">${idx}</a>
		    </li>
		</c:forEach>
		
		<!-- next 버튼 -->
		<li id="page-next">
		    <a href="list${pageMaker.makeQuery(pageMaker.endPage + 1)}" aria-label="Next">
		    	<span aria-hidden="true">»</span>
		    </a>
		</li>
		
	</ul>
</div>



<script>
	$(function(){

		//prev 버튼 활성화, 비활성화 처리
		var canPrev = '${pageMaker.prev}';
		if(canPrev !== 'true'){
			$('#page-prev').addClass('disabled');
		}
		
		//next 버튼 활성화, 비활성화 처리
		var canNext = '${pageMaker.next}';
		if(canNext !== 'true'){
			$('#page-next').addClass('disabled');
		}
		
		//현재 페이지 파란색으로 활성화
		var thisPage = '${pageMaker.cri.page}';
		//매번 refresh 되므로 다른 페이지 removeClass 할 필요는 없음->Ajax 이용시엔 해야함
		$('#page'+thisPage).addClass('active');
	});
	

</script>