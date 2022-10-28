<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../include/header.jsp" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<title>Member-Join</title>
</head>
<body>

	<div class="super_container">
	
		<div class="all_container">
	
			<div class="title">
				<h1>회원가입</h1>
			</div>
			
			<br>
			
			<div class="join">
			<form action="${pageContext.request.contextPath}/member/join" method="post">
				
				<div>
					<label>아이디</label>
					<input type="text" name="memId" id="memId" max="20" required="required">
					&nbsp;<button class="idChk" type="button" id="idChk" onclick="fn_idChk()" value="N">중복확인</button>
				</div>
				
				<div>
					<label>비밀번호</label>
					<input type="password" name="memPw" id="memPw" placeholder="비밀번호" max="100" required="required">
				</div>
				
				<div>
					<label>비밀번호 확인</label>
					<input type="password" name="pwConfirm" id="pwConfirm" placeholder="비밀번호 확인" onkeyup="fn_pwConfirm()" max="100" required="required">
					&nbsp;&nbsp; <span id ="confirm-success" style="display:none; color: green;">비밀번호 일치</span>
					&nbsp;&nbsp; <span id ="confirm-fail" style="display:none; color:red;">비밀번호 불일치</span>
				</div>
				
				<div>
					<label>이름</label>
					<input type="text" name="memName" id="memName" max="20" required="required">
				</div>
				
				<div>
					<label>이메일</label>
					<input type="text" name="memEmail" id="memEmail" max="50" required="required">
					&nbsp;<button class="emailChk" type="button" id="emailChk" onclick="fn_emailChk()" value="N">중복확인</button>
				</div>
				
				<div>
					<label>전화번호</label>
					<input type="text" name="memPhone" id="memPhone" max="30" required="required">
				</div>
				
				
				<script>
					
					function fn_idChk(){
						$.ajax({
							url : "${pageContext.request.contextPath}/member/idChk",
							type : "post",
							dataType : "json",
							data : {"memId" : $("#memId").val()},
							success : function(data){
								if(data == "1"){
									alert("중복된 아이디입니다. 아이디를 다시 입력해주세요.");
								} else {
									$("#idChk").attr("value", "Y");
									alert("사용가능한 아이디입니다.");
								}
							}
						});
					}
					
					function fn_emailChk(){
						$.ajax({
							url : "${pageContext.request.contextPath}/member/emailChk",
							type : "post",
							dataType : "json",
							data : {"memEmail" : $("#memEmail").val()},
							success : function(data){
								if(data == "1"){
									alert("이미 존재하는 이메일입니다. 다시 입력해주세요.");
								} else {
									$("#emailChk").attr("value", "Y");
									alert("사용가능한 이메일 입니다.");
								}
							}
						});
					}
					
					
					function fn_pwConfirm(){
						
						var memPw = $('#memPw').val();
						var pwConfirm = $('#pwConfirm').val();
						
						if(memPw != "" || pwConfirm != ""){
							
							if(memPw == pwConfirm){
								$("#confirm-success").css('display', 'inline-block');
								$("#confirm-fail").css('display', 'none');
								$("#submit").removeAttr("disabled");
							} else {
								$("#confirm-success").css('display', 'none');
								$("#confirm-fail").css('display', 'inline-block');
								$("#submit").attr("disabled", "disabled");
							}
						}
					}
	
				</script>
				
				
				<br>
				
				
				<div>
				
					<h4>이용약관동의</h4>
					
					<div class="panel-body" style="border:2px solid #cc">
						<p>어쩌고 저쩌고</p>
					</div>
					
					<label class="checkbox-inline">
	                    <input type="checkbox" id="agree" name="agree" value="true"/>동의합니다.
	                </label>
	                
					<br>
					
					<h4>개인정보동의</h4>
					
					<div class="panel-body" style="border:2px solid #cc">
						<p>어쩌고 저쩌고</p>
					</div>
					
					<label class="checkbox-inline">
	                    <input type="checkbox" id="agree" name="agree" value="true"/>동의합니다.
	                </label>
	                
				</div>
				
				<div>
					<button type="submit" id="submit">가입하기</button>
				</div>
				
				<script>
	
					var agree = $('#agree').val();
					
	               	$('#submit').click(function(){
	               		
	               		if(agree == null){
	               			alert("모든 이용약관에 동의하셔야 회원가입이 가능합니다.");
	               		} else {
	               			location.href = "${pageContext.request.contextPath}/member/welcome";
	               		}
	               		
	               	});
	
	             </script>
	
				
			</form>
			</div>
			
		</div>	
	
	</div>

</body>
</html>