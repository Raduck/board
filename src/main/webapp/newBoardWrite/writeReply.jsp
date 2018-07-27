<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- SmartEditor를 사용하기 위해서 다음 js파일을 추가 (경로 확인) -->
<script type="text/javascript" src="/SE2/js/HuskyEZCreator.js"
	charset="utf-8"></script>
<!-- jQuery를 사용하기위해 jQuery라이브러리 추가 -->
<script src="/js/jquery-1.12.4.js"></script>
<link rel="icon" href="../../favicon.ico">
<link href="/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="/bootstrap/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">

<script type="text/javascript">
	var oEditors = [];
	$(function() {
		nhn.husky.EZCreator.createInIFrame({
			oAppRef : oEditors,
			elPlaceHolder : "ir1", //textarea에서 지정한 id와 일치해야 합니다. 
			//SmartEditor2Skin.html 파일이 존재하는 경로
			sSkinURI : "/SE2/SmartEditor2Skin.html",
			htParams : {
				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseToolbar : true,
				// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseVerticalResizer : true,
				// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
				bUseModeChanger : true,
				
				fOnBeforeUnload : function() {

				}
			},
			fOnAppLoad : function() {
				//기존 저장된 내용의 text 내용을 에디터상에 뿌려주고자 할때 사용
				oEditors.getById["ir1"].exec("PASTE_HTML",
						[ "============================================================" ]);
			},
			fCreator : "createSEditor2"
		});

		//저장버튼 클릭시 form 전송
		$("#save").click(function() {
			oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
			$("#frm").submit();
		});
	    $("#cansel").click(function() {
			$("#frm1").submit();
		});
	});
	//필수값 Check
function validation() {
	var contents = $.trim(oEditors[0].getContents());
	if (contents === '<p>&bnsp;</p>' || contents === '') {
		// 기본적으로 아무것도 입력하지 않아도 값이 입력되어 있음. 
		alert("내용을 입력하세요.");
		oEditors.getById['smarteditor'].exec('FOCUS');
		return false;
	}
	return true;
}
</script>
</head>
<body>

	<%@include file="/common/top.jsp"%>
	
	<div class="container-fluid">
		<div class="row">

			<!-- left.jsp -->
			<%@include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">



	<form id="frm1" action="/WriteServlet?board_id=${board_id}&page=1&pageSize=10" method="post"></form>
	<form id="frm" action="/writeReply" method="post">
		<input type="hidden" name="board_id" value="${board_id}">
		<input type="hidden" name="wr_id" value="${wr_id }">
		<table width="100%">
			<tr>
				<td>제목</td>
				<td><input type="text" id="title" name="wr_title"
					style="width: 650px" /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" cols="30" id="ir1" name="wr_content"
						style="width: 850px; height: 550px;"></textarea></td>
			</tr>
		</table>
			<br>
			<div class="form-group">
				<label class="col-sm-2 control-label"></label>
				<div class="col-sm-7">
				</div>
				<div class="col-sm-2">
				 	<input type="button" id="cansel" value="취소" class="btn btn-info"/></td>
					<input type="button" id="save" value="저장" class="btn btn-primary"/>
				</div>
				<div class="col-sm-1">
				</div>
			</div>
	</form>
	
	
		</div>
	</div>
</div>
</body>
</html>