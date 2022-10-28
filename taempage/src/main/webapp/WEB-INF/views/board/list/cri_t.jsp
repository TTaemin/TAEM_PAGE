<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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


<script>
	$(function(){
		//perPageNum select 박스 설정
		setPerPageNumSelect();
	});

	function setPerPageNumSelect(){
		var cateNo = "${pageMaker.cri.cateNo}";
		var perPageNum = "${pageMaker.cri.perPageNum}";
		var $perPageSel = $('#perPageSel');
		var thisPage = '${pageMaker.cri.page}';
		$perPageSel.val(perPageNum).prop("selected",true);
		//PerPageNum가 바뀌면 링크 이동
		$perPageSel.on('change',function(){
			//pageMarker.makeQuery 사용 못하는 이유: makeQuery는 page만을 매개변수로 받기에 변경된 perPageNum을 반영못함
			window.location.href = "list?cate=" + cateNo + "&page=" + thisPage + "&perPageNum=" + $perPageSel.val();
		});
	}
	
</script>