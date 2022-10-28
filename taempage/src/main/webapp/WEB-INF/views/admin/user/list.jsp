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

<title>(admin) user_list</title>

<script>
	/* 삭제 버튼 클릭시 */
	
	$(function(){
		
		$('#btn-memDel').click(function(){
			if(confirm("삭제하시겠습니까?")){				
				self.location.href="${pageContext.request.contextPath}/admin/user/delete";
			} else {
				return false;
			}
		});
	});
</script>


</head>
<body>

	<div class="super_container">
		
		<div class="all_container">
		
			<div>
				<a href="${pageContext.request.contextPath}/admin/main_page">ADMIN 페이지로 가기</a>
			</div>
			
			<div>
				<table>
				
					<thead>
						<tr>
							<th>
								<div class="allChk">
									<input type="checkbox" name="allCheck" id="allCheck" />
									<script>
										$("#allCheck").click(function(){
											var chk=$("#allCheck").prop("checked");
											
											if(chk){
												$(".chkBox").prop("checked", true);
											}else{
												$(".chkBox").prop("checked", false);
											}
										});
									</script>
								</div>
							</th>
							<th>No.</th>
							<th>ID</th>
							<th>Name</th>
							<th>E-mail</th>
							<th>Phone</th>
							<th>Join-Date</th>
						</tr>
					</thead>
			
					<tbody>
					<c:forEach items="${user}" var="user">
						<tr>
							<td>
								<div class="chkBox">
								<input type="checkbox" name="chkBox" class="chkBox" data-memNo="${user.memNo }" />
									<script>
										$(".chkBox").click(function(){
											$("#allCheck").prop("checked", false);
										});
									</script>
								</div>
							</td>
							<td>${user.memNo}</td>
							<td>${user.memId}</td>
							<td>${user.memName}</td>
							<td>${user.memEmail}</td>
							<td>${user.memPhone}</td>
							<td><fmt:formatDate value="${user.joinDate }" pattern="yyyy. MM. dd"/></td>
							<td>
								<button type="button" id="btn-userUdp" onclick="location.href='<c:url value="/admin/user/update?no=${user.memNo }"/>'">수정하기</button>
								<button type="button" id="btn-userDel" class = "btn-${user.memNo}-del" data-memNo="${user.memNo}">탈퇴시키기</button>
								<script>
									$(".btn-${user.memNo}-del").click(function(){
										var confirm_var=confirm("삭제하시겠습니까?");
										
										if(confirm_var){
											var checkArr=new Array();
											
											checkArr.push($(this).attr("data-memNo"));
											
											$.ajax({
												url: "${pageContext.request.contextPath}/admin/user/delete",
												type: "post",
												data: { chkbox : checkArr },
												success: function(result){
													if(result == 1){
														location.href="${pageContext.request.contextPath}/admin/user/list";
													}else{
														alert("삭제실패");
													}
												}
											});
										}
									});
								</script>
							</td>
						</tr>
					</c:forEach>
					</tbody>

				</table>

				<hr>
				
			</div>

		</div>
	
		<div class="delBtn">
			<button type="button" class="btn-selDel">선택삭제
			
			<script>
				$(".btn-selDel").click(function(){
					var confirm_var=confirm("선택한 멤버를 삭제하시겠습니까?");
					
					if(confirm_var){
						var checkArr=new Array();
						
						$("input[class='chkBox']:checked").each(function(){
							checkArr.push($(this).attr("data-memNo"));
						});
						
						$.ajax({
							url: "${pageContext.request.contextPath}/admin/user/delete",
							type: "post",
							data: { chkbox : checkArr },
							success: function(result){
								if(result ==  1){
									location.href = "${pageContext.request.contextPath}/admin/user/list";
								}else{
									alert("선택 삭제 실패");
								}
							}
						});
					}
				});
			</script>
			
			</button>
		</div>
	
	
	</div>
	
</body>
</html>