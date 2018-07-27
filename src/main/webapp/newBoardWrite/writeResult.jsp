<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<form action="/WriteDetail" method="get" id="frm">
		<input type="hidden" name="wr_id" id="wr_id">
		<input type="hidden" name="board_id" id="board_id" value="${board_id}">
	</form>
	<div class="container-fluid">
		<div class="row">

			<!-- left.jsp -->
			<%@include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			
			
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header"></h2>
						<div class="table-responsive">
							<table class="table table-striped table-hover">
							<thead>
								<tr>
									<th>게시글 번호</th>
									<th>제목</th>
									<th>작성자 아이디</th>
									<th>작성 일시</th>
								</tr>
								</thead>
								<tbody>
								<c:forEach items="${writeList }" var="vo">
									<!-- 태그 클릭시 상세보기로 이동 -->
									<c:choose>
									<c:when test="${'n' eq vo.wr_dl}">
									<tr data-wr_id="${vo.wr_id }">
										<td>${vo.wr_id }</td>
										<td>${vo.wr_title}</td>
										<td>${vo.std_id}</td>
										<td><fmt:formatDate value="${vo.wr_date}" pattern="yyyy-MM-dd"/></td>
									</tr>
									</c:when>
									<c:when test="${'y' eq vo.wr_dl}">
									<tr onclick='event.cancelBubble=true;'>
										<td onclick='event.cancelBubble=true;'>${vo.wr_id }</td>
										<td onclick='event.cancelBubble=true;'>[삭제된 게시글 입니다.]</td>
										<td onclick='event.cancelBubble=true;'>삭제글</td>
										<td onclick='event.cancelBubble=true;'><fmt:formatDate value="${vo.wr_date}" pattern="yyyy-MM-dd"/></td>
									</tr>
									</c:when>
									</c:choose>
								</c:forEach>
								</tbody>

							</table>
						</div>
						<form action="/writeNew" method="get" id="frm1" name="frm1">
							<input type="submit" id="newBoardBtn" name="newBoardBtn" class="btn btn-default" value="새 글쓰기">
							<input type="hidden" name="board_id" value="${board_id}">
						</form>
						<div class="text-center">
							<ul class="pagination">
								<%=request.getAttribute("pageNavi")%>
							</ul>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

</body>
<script>
$(function() {
	$("table tbody tr").on("click", function() {
		//tr태그의 data-id 속성 값을 읽어서 input 태그의 id 값으로 설정
		//form 태그를 submit
		$("#wr_id").val($(this).data("wr_id"));
		//확인용
		console.log("table tbody tr clicked : "+$(this).data("wr_id"));
		$("#frm").submit();
	});
});
</script>
</html>