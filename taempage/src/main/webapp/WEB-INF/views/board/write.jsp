<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../include/header.jsp" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/ckeditor/ckeditor.js"></script>
<title>Insert title here</title>
</head>
<script>

	/*ck 에디터*/
	var ckeditor_config = {
			skin: 'bootstrapck',
			filebrowserUploadUrl: '${pageContext.request.contextPath}/board/ckUpload'		
	};

		
</script>



<body>
	
	<div class="super_container">
	
		<div class="all_container">
	
			<h2>글쓰기</h2>
			
			<div>
			<form action="${pageContext.request.contextPath}/board/write" method="post" enctype="multipart/form-data">
				
				<div>
					<label>제목</label>
					<input type="text" name="title" id="title">
				</div>
				
				<div>
					<label>카테고리</label>
					<select class="cate" name="cateNo" id="cateNo">
						<option value="">카테고리</option>
						<option value="100">INTRODUCE</option>
						<option value="200">PORTFORIO</option>
						<option value="300">LOG</option>
						<option value="400">TRAVEL</option>
						<option value="500">RANDOM</option>
					</select>
				</div>
				
				<div>
					<label>내용</label>
					<textarea name="content" id="content"></textarea>
					<script>
						CKEDITOR.replace("content", ckeditor_config);
					</script>
				</div>
				
				<div>
					<label>비공개설정</label>
					<input type="radio" name="open" id="openY" value="Y"><span class="ml_10">공개</span>
					<input type="radio" name="open" id="openN" value="N"><span class="ml_10">비공개</span>

				</div>
				
				<div class="btn">
					<input type="submit" id="btn-submit" value="글쓰기" style="background-color: transparent; color: #400040; border: 0px transparent solid;"/>
				</div>
				
				
			</form>
			</div>
		
		</div>
		
	</div>


</body>
</html>