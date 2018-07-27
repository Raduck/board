<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="../../favicon.ico">
<title>Insert title here</title>
<script src="/js/jquery-1.12.4.js"></script>
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
<div class="blog-header">
	<h1 class="blog-title">새 게시판 생성 ${param.redirectFrom }</h1>
	<p class="lead blog-description">Jsp / Spring.</p>
</div><br><br><br>

	<form action="/NewBoard" class="newBoardForm" name="newBoardForm"
		method="get" class="form-inline">
		<div class="row">
		<div class="col-md-1">
			<label for="newBoardName">게시판 이름</label> 
		</div>
		<div class="col-md-7">
			<input type="text" id="newBoardTitle" name="newBoardTitle" class="form-control"
				placeholder="새 게시판 이름을 입력하세요">
		</div>
		<div class="col-md-2">
			<select name="useable" id="useable" onchange="" class="form-control">
				<option value="y">사용</option>
				<option value="n">미사용</option>
				<!--<option value="" ${locale eq '' ? "selected" : '' }></option>  -->
			</select> 
		</div>
		<div class="col-md-2">
			<input type="submit" id="newBoardBtn" name="newBoardBtn"
				class="btn btn-default" value="생성">
		</div>
		</div>
	</form><br><br><br>
<!-- form 끝 ------------------------------------------- -->
<c:forEach items="${newBoardList }" var="vo">
	<form action="/UpdateBoard" class="updateBoardForm" name="updateBoardForm"
		method="post" class="form-inline">
		<input id="board_id${vo.board_id }" name="board_id" type="hidden" value="${vo.board_id }">
		<div class="row">
		<div class="col-md-1">
			<label for="updateBoardName">게시판 이름</label> 
		</div>
		<div class="col-md-7">
			<input type="text" id="updateBoardTitle${vo.board_id }" name="updateBoardTitle" class="form-control"
				placeholder="${vo.board_title }">
		</div>
		<div class="col-md-2">
			<select id="useable${vo.board_id }" name="useable" onchange="" class="form-control">
				<option value="y">사용</option>
				<option value="n">미사용</option>
				<!--<option value="" ${locale eq '' ? "selected" : '' }></option>  -->
			</select> 
		</div>
		<div class="col-md-2">
			<input type="submit" id="updateBoardBtn" name="updateBoardBtn"
				class="btn btn-default" value="수정">
		</div>
		</div>
	</form><br><br><br>
</c:forEach>
<!-- form 끝 ------------------------------------------- -->
	
<!-- form 끝 ------------------------------------------- -->
	</div>
</div>
</div>
</body>
<script>
$( document ).ready(function() {
    console.log( "ready!" );
    //수정완료 되면 알람창 뜨게 해보자
    
    $.urlParam = function(name){
        var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
        if (results==null){
           return null;
        }
        else{
           return decodeURI(results[1]) || 0;
        }
    }
    
    var resultInsert = $.urlParam('resultInsert');
    	if (resultInsert>1){
		alert("게시판 수정이 성공적으로 완료 하였습니다.");    		
		}
    var result = $.urlParam('result');
    	if (result>1){
			alert("게시판 수정이 성공적으로 완료 하였습니다.");    		
    	}
    
    
});
</script>
</html>