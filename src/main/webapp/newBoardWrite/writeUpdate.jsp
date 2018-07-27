<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>

<script src="/js/jquery-1.12.4.js"></script>
<link href="/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="/bootstrap/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">
<link href="/css/common.css" rel="stylesheet">

</head>

<body>
	<%@include file="/common/top.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<%@include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<form id="frm" class="form-horizontal" role="form" method="post"
					name="writeForm" enctype="multipart/form-data">

					<input type="hidden" name="board_id" value="${board_id}"> <input
						type="hidden" name="wr_id" value="${wrVo.wr_id }">
					<table width="100%">
						<tr>
							<td>제목</td>
							<td>
							<input type="text" id="title" name="wr_title"
								style="width: 650px" value="${wrVo.wr_title }"/></td>
						</tr>
						<tr>
							<td>내용</td>
							<td>
							<%@ include file="/SE2/index.jsp" %>
							</td>
						</tr>
					</table>

					
					<div class="form-group" id="uploadDiv">
						<label class="col-sm-2 control-label">첨부파일</label>
						<div class="col-sm-3">
							<input type="file" name="uploadFile"
								enctype='multipart/form-data' multiple>
						</div>
						<div class="col-sm-2"></div>
						<div class="col-sm-5"></div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label"></label>
						<div class="col-sm-7"></div>

						<div class="col-sm-3">
							<input type="button" value="저장" onclick="mappingAction('save');"
								class="btn btn-default">
						</div>
					</div>

				</form>

				<!-- 파일 리스트 여기에 출력 -->

			</div>
		</div>
	</div>
</body>
<script type="text/javascript">

$( document ).ready(function() {
    console.log( "ready!" );
});
function mappingAction(val) {
    
    var form = document.writeForm;
 
    if (val == "save") {
        form.action = "/writeUpdate";
    } else if (val == "upload") {
        form.action = "#";
    } else {
        return false;
    }
    form.submit();
}
var oEditors = [];
</script>
<script type="text/javascript">
$(document).ready(function() {
	//저장버튼 클릭시 form 전송
	$("#save").click(function() {
		oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
		$("#frm").submit();
	});
    $("#cansel").click(function() {
		$("#frm1").submit();
	});
});
/* //필수값 Check
function validation() {
var contents = $.trim(oEditors[0].getContents());
if (contents === '<p>&bnsp;</p>' || contents === '') {
	// 기본적으로 아무것도 입력하지 않아도 값이 입력되어 있음. 
	alert("내용을 입력하세요.");
	oEditors.getById['smarteditor'].exec('FOCUS');
	return false;
}
return true;
} */
</script>
</html>
