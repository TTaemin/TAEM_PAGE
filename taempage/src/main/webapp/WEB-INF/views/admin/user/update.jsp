<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<title>(Seller) user Update</title>
</head>
<body>
	
	<div class="table-wrapper" style="margin-left:250px;margin-top:200px;overflow-x:auto;max-width:70% ">
		<form action="${pageContext.request.contextPath}/admin/member/update?no=${user.memNo}" method="post">
			<table style="width:100%">
				<tr>
					<th>No.</th>
					<td><input type="text" name="memNum" value="${user.memNo}" readonly="readonly"></td>
				</tr>
				<tr>
					<th>ID</th>
					<td><input type="text" name="memId" value="${user.memId}" max="20"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="memName" value="${user.memName}" max="10"></td>
				</tr>
				<tr>
					<th style="width:50px">이메일</th>
					<td style="width:500px"><input type="text" name="email" value="${user.email}"></td>
				</tr>
				<tr>
					<th style="width:50px">전화번호</th>
					<td style="width:500px"><input type="text" name="phone" value="${user.phone}"></td>
				</tr>
				<tr>
					<th style="width:50px">가입일</th>
					<td><fmt:formatDate value="${user.joinDate }" pattern="yyyy. MM. dd" /></td>
				</tr>
			</table>
			
			<div class="form-group has-feedback" align="right">
				<button type="submit">수정</button>
			</div>
			
		</form>
	</div>

</body>
</html>