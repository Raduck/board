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
</head>
<body>

	<%@include file="/common/top.jsp"%>
	
	
	<div class="container-fluid">
		<div class="row">

			<!-- left.jsp -->
			<%@include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">



	<form id="frm1" action="/WriteServlet?board_id=${board_id}&page=1&pageSize=10" method="post"></form>
	<form id="frm" action="/writeNew" method="post" enctype="multipart/form-data">
		<input type="hidden" name="board_id" value="${board_id}">
		<table width="100%">
			<tr>
				<td>제목</td>
				<td><input type="text" id="title" name="wr_title"
					style="width: 650px" /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
				<%@ include file="/SE2/index.jsp" %>
				</td>
			</tr>
		</table>
			<br>
			<div class="form-group">
				<label class="col-sm-2 control-label"></label>
				<div class="col-sm-4">
				</div>
				<div class="col-sm-2">
				 	<input type="button" id="cansel" value="취소" class="btn btn-info"/></td>
					<input type="button" id="save" value="저장" class="btn btn-primary"/>
				</div>
				<div class="col-sm-3">
				</div>
			</div>
			<br>
			<div class="form-group" id="uploadDiv">
				<label class="col-sm-1 control-label">첨부파일</label>
				<div class="col-sm-2">
					<input type="file" name="uploadFile" enctype='multipart/form-data' multiple>
				</div>
				<div class="col-sm-2">
				</div>
				<div class="col-sm-6">
				</div>
			</div>
			
			
	</form>
		<br>
	
	
		</div>
	</div>
</div>
</body>
<script type="text/javascript">
var oEditors = [];
$(document).ready(function() {
	$("#save").click(function(){
		if(confirm("저장하시겠습니까?")) {
			// id가 smarteditor인 textarea에 에디터에서 대입
			oEditors.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);

			// 이부분에 에디터 validation 검증
			if(validation()) {
				$("#frm").submit();
			}
		}
	})
	//저장버튼 클릭시 form 전송
	/* $("#save").click(function() {
		oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
		$("#frm").submit();
	}); */
    $("#cansel").click(function() {
		$("#frm1").submit();
	});
    /* // test_btn 버튼의 쿠키값을 검사한다. -  값이 Y 인경우 testDiv 부분 open
    if($.cookie("test_btn") == "N"){
          $("#testDiv").hide();
          //$("#testImage").attr("src","/images/open_test_btn.gif");
          //버튼이미지 변경
    } else {
          $("#testDiv").show();
         // $("#testimg").attr("src","/images/close_test_btn.gif");
    } */
	/* function showHide(){
        if(document.getElementById("uploadFrm").style.display =='none'){
            document.getElementById("uploadFrm").style.display ='block';
        }
        else{
            document.getElementById("uploadFrm").style.display ='none';
        }
   	} */
	$(function(){
        var addFileTag = "<input type=\"file\" class=\"form-control\" style=\"margin-top:10px;\" multiple=\"chum\" id=\"chum\" name=\"chum\">"; // file tag                        
        var fileListSize = $("#file-btn-list").length; // list size
        
        $("#addBtn").click(function(){
           if(fileListSize < 5) {
              $("#file-btn-list").append(addFileTag);
              fileListSize++;                              
           } else {
              alert("파일은 5개까지만 가능합니다.");
           }
        });
     });
});

</script>
</html>