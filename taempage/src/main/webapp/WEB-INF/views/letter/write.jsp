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
<title>Letter Write</title>
</head>
<script>

	/*ck 에디터*/
	var ckeditor_config = {
			skin: 'bootstrapck',
			filebrowserUploadUrl: '${pageContext.request.contextPath}/letter/ckUpload'		
	};

		
</script>



<body>
	
	<div class="super_container">
	
		<div class="all_container">
		
			<h2>글쓰기</h2>
			
			<div>
			<form action="${pageContext.request.contextPath}/letter/write" method="post" enctype="multipart/form-data">
				<input type="hidden" name="memNo" id="memNo" value="${member.memNo}">
				
				<div>
					<label>제목</label>
					<input type="text" name="lTitle" id="lTitle" required="required">
				</div>
							
				<div>
					<label>내용</label>
					<textarea name="lContent" id="lContent"></textarea>
					<script>
						CKEDITOR.replace("lContent", ckeditor_config);
					</script>
				</div>
				
				<div>
					<label>비밀번호</label>
					<input type="password" name="lPassword" id="lPassword" required="required" />

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