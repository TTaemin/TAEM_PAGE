<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="../include/header.jsp" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/ckeditor/ckeditor.js"></script>

<title>Board Update</title>
</head>
<script>
var ckeditor_config = {
		skin: 'bootstrapck',
		filebrowserUploadUrl: '${pageContext.request.contextPath}/board/ckUploadUpd'
};
</script>
<body>

	<div class="super_container">
	
		<div class="all_container">
		
		<h2>수정하기</h2>
		
		<br>
		
		<form action="${pageContext.request.contextPath}/board/update?no=${board.boardNo}" method="post" enctype="multipart/form-data">
			<input type="hidden" name="boardNo" id="boardNo" value="${board.boardNo }" />
			
			<div>
				<label>제목</label>
				<input type="text" name="title" id="title" value="${board.title}" />
			</div>
			
			<div>
				<label>카테고리</label>
				<select class="cate" name="cateNo" id="cateNo">
					<option value="${board.cateNo}">카테고리</option>
					<option value="100">INTRODUCE</option>
					<option value="200">PORTFORIO</option>
					<option value="300">LOG</option>
					<option value="400">TRAVEL</option>
					<option value="500">RANDOM</option>
				</select>
			</div>
			
			<div>
				<textarea name="content" id="content"></textarea>
				<script>
					CKEDITOR.replace("content", ckeditor_config);
				</script>
			</div>

			<div>
				<label>비공개설정</label>
				<input type="radio" name="open" id="openY" value="Y" class="radio" /><span class="ml_10">공개</span>
				<input type="radio" name="open" id="openN" value="N" class="radio" /><span class="ml_10">비공개</span>
			</div>
			
			<br>
			
			<div class="btn">
				<input type="submit" id="btn-submit" value="수정하기" style="background-color: transparent; color: #400040; border: 0px transparent solid;"/>
			</div>

			
		</form>	
		</div>
	
	</div>

</body>
</html>