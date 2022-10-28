<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="../include/header.jsp" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Board View</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/styles/main_styles.css'/>">
<script>
function replyList() {
	
	var boardNo = ${board.boardNo};
	
	$.getJSON("${pageContext.request.contextPath}/board/replyList/" + "?no=" + boardNo, function(data){
		var str = "";
	 
		$(data).each(function(){
	   
			var replyDate = new Date(this.replyDate);
			replyDate = replyDate.toLocaleDateString("ko-US")
	   
			str += "<li data-replyNo='" + this.replyNo + "'>"
				+ "<div class='memberInfo'>"
				+ "<span class='memberId'>" + this.memId + "</span> &nbsp;"
				+ "<span class='date'>" + replyDate + "</span>"
				+ "</div>"
				+ "<div class='reply'>" + this.reply + "</div></br>"
				
				+ "<c:if test='${member != null}'>"
				
				+ "<div class='replyChange'>"
				+ "<button type='button' class='btn-repUpd' data-replyNo='" + this.replyNo + "'>수정</button>"
				+ "<button type='button' class='btn-repDel' data-replyNo='" + this.replyNo + "'>삭제</button>"
				+ "</div>"
				
				+"</c:if>"
				
				+ "</li>";

		});
	  
		$("section.replyList ol").html(str);
	});
	
}
</script>

</head>

<style>
	div.replyModal { position:relative; z-index:1; display:none; }
	div.modalBackground { position:fixed; top:0; left:0; width:100%; height:100%; background:rgba(0, 0, 0, 0.8); z-index:-1; }
	div.modalContent { position:fixed; top:20%; left:calc(50% - 250px); width:500px; height:250px; padding:20px 10px; background:#fff; border:2px solid #666; }
	div.modalContent textarea { font-size:16px; font-family:'맑은 고딕', verdana; padding:10px; width:500px; height:200px; }
	div.modalContent button { font-size:20px; padding:5px 10px; margin:10px 0; background:#fff; border:1px solid #ccc; }
	div.modalContent button.modal_cancel { margin-left:20px; }
</style>

<body>

	<div class="super_container">
		
		<div class="all_container">
		
			<h2>글 상세보기</h2>
			
			<br>
		
			<div class="board_view">
				<div>
					<h2>${board.title}</h2>
				</div>
				
				<hr>
				
				<div>
					<h4>카테고리</h4> <p>${board.cateName}</p>
				</div>
				
				<hr>
				
				<div>
					<h4>작성자</h4> <p>Alex Seo</p>
				</div>
				
				<hr>
				
				<div>
					<p><fmt:formatDate value="${board.boardDate}" pattern="yyyy. MM. dd" /></p>
				</div>
				
				<hr>
				<br>
				
				<div>
					<p>${board.content }</p>
				</div>
				
				<hr>
				<br>
						
			</div>
			
			<br>
			
			<div id="댓글">

				<h4>댓글 작성</h4>
				
				<c:if test="${member == null }">
					<p>답변 작성시 <a href="<c:url value="/member/login"/>">로그인</a> 이 필요합니다.</p>
				</c:if>
				
				<c:if test="${member != null }">
					<section class="replyWrite">
					<form role="form" id="frm" method="post">
						
						<input type="hidden" name="boardNo" id="boardNo" value="${board.boardNo }">
						
						<div class="input_area">
							<textarea name="reply" id="reply"></textarea>
						</div>
						<div class = "input_area">
							<button type="button" id="btn-reply">등록</button>
							
							<script>
								$("#btn-reply").click(function(){
									
									var formObj = $(".replyWrite form[role='form']");
									var boardNo = $("#boardNo").val();
									var reply = $("textarea#reply").val();
									
									var data = {
											boardNo: boardNo,
											reply: reply
									};
									
									$.ajax({
										url:"${pageContext.request.contextPath}/board/replyWrite",
										type: "post",
										data: data,
										success: function(){
											replyList();
											$("textarea#reply").val("");
										}
									});
									
								});
							</script>
							
						</div>
						
					</form>
					</section>
				</c:if>
				
				<br>
				
				<h3>댓글 리스트</h3>
				
				<section class="replyList">

					<ol>

					</ol>
					
					<script>
						replyList();
					</script>
					
					<script>
						$(document).on("click", ".btn-repDel", function(){
							
							var delConfirm = confirm("정말 삭제하시겠습니까?");
							
							if(delConfirm){
								
								var data = {replyNo: $(this).attr("data-replyNo")};
								
								$.ajax({
									url:"${pageContext.request.contextPath}/board/replyDelete",
									type: "post",
									data: data,
									success: function(result){
										if(result == 1){
											replyList();
										}else{
											alert("작성자만 삭제할 수 있습니다.");
										}
									},
									error: function(){
										alert("로그인하셔야 합니다.");
									}
								});
							}
						});
						
						
						$(document).on("click", ".btn-repUpd", function(){
							 $(".replyModal").attr("style", "display:block;");
							 
							 var replyNo = $(this).attr("data-replyNo");
							 var reply = $(this).parent().parent().children(".reply").text();
							 
							 $(".modal_reply").val(reply);
							 $(".btn-modal_repUpd").attr("data-replyNo", replyNo);
							 
						});
					</script>
					
				</section>
				
			</div>
			
			<br>
			
			<div class="btn">
				<a href="${pageContext.request.contextPath}/board/list${cri.makeQuery()}">목록으로 가기</a>
			</div>
			
			<c:if test="${member.verify == 7}">
				<div class="btn">
					<a href="${pageContext.request.contextPath}/board/update?no=${board.boardNo}" id="btn-bdUpd">수정하기</a>
				</div>
				<div class="btn">
					<a id="btn-bdDel">삭제하기</a>
				</div>
			</c:if>
	
		</div>
	
	</div>
	
	<script>
		$("#btn-bdDel").click(function(){
			if(confirm("글을 삭제하시겠습니까?")){
				location.href="${pageContext.request.contextPath}/board/delete?no=" + ${board.boardNo};
			}else{
				return false;
			}
		});
	</script>
	
	
	
		<div class="replyModal">

		<div class="modalContent">
		  
			<div>
				<textarea class="modal_reply" name="modal_reply"></textarea>
			</div>
			  
			<div>
				<button type="button" class="btn-modal_repUpd">수정</button>
				<button type="button" class="btn-modal_cancel">취소</button>
			</div>
		  
		</div>
		
		<div class="modalBackground"></div>
	 
	</div>
	
	<script>
		$(".btn-modal_cancel").click(function(){
			$(".replyModal").attr("style", "display:none;");
		});
		
		
		$(".btn-modal_repUpd").click(function(){
			var modifyConfirm = confirm("정말 수정하시겠습니까?");
			 
			if(modifyConfirm) {
				var data = {
			
					replyNo : $(this).attr("data-replyNo"),
					reply : $(".modal_reply").val()
				};  // reviewVO 형태로 데이터 생성
			  
					$.ajax({
						url : "${pageContext.request.contextPath}/board/replyUpdate",
						type : "post",
						data : data,
						success : function(result){
					   
						if(result == 1) {
							replyList();
							$(".replyModal").attr("style", "display:none;");
						} else {
							alert("작성자만 수정할 수 있습니다.");       
						}
					},
						error : function(){
						alert("로그인하셔야합니다.");
					}
				});
			}
					 
		});
	</script>
 

</body>
</html>