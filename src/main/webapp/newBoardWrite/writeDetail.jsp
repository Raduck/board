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

	<div class="container-fluid" >
		<div class="row">

			<%@include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<form id="frm" role="form" method="post" class="form-horizontal"
					name="writeForm">
					<input type="hidden" name="board_id" value="${board_id}"> <input
						type="hidden" name="wr_id" value="${WriteVo.wr_id }"> <input
						type="hidden" name="wr_title" value="${WriteVo.wr_title}">

					<div class="form-group">
						<label class="col-sm-2 control-label">제목</label>
						<div class="col-sm-10">
							<label class="control-label input-lg" name="wr_title">${WriteVo.wr_title }</label>

						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">글 내용</label>
						<div class="col-sm-8">${WriteVo.wr_content }</div>
						<div class="col-sm-2"></div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label"></label>
						<div class="col-sm-7">
							<%-- <c:forEach items="" var="">
							<label class="control-label"></label>
							</c:forEach> --%>
						</div>
						<div class="col-sm-3">
							<input type="button" value="수정"
								onclick="mappingAction('update');" class="btn btn-default">
							<input type="button" value="답글" onclick="mappingAction('reply');"
								class="btn btn-default">
							<c:if test="${WriteVo.std_id == id}">
								<input type="button" value="삭제"
									onclick="mappingAction('delete');" class="btn btn-default">
							</c:if>
						</div>
					</div>
				

					<!-- 
					여기에 첨부파일 
					목록 출력
					 -->
					<div class="form-group">
						<label class="col-sm-2 control-label">첨부파일</label>
						<div class="col-sm-8">
							<c:forEach items="${uploadFileList }" var="vo" varStatus="i">
								<a href="/fileDownload?file_upnm=${vo.file_upnm}&fileName=${vo.file_nm}">${vo.file_upnm }</a>
								<br>
							</c:forEach>
						</div>
						<div class="col-sm-2"></div>
					</div>
					<label for="userNm" class="col-sm-2 control-label">댓글</label>
				</form>
				
					


					<!-- -------------첫번째 댓글-------------------------- -->
					<c:forEach items="${replyList}" var="rpVo" begin="0" end="0">
						<div class="form-group">
						<!-- ------------------------------------------------------ -->
						<form method="post" class="form-horizontal" action="/replyDelete">
							<input type="hidden" id="id" name="id" value="${WriteVo.wr_id }">
							<input type="hidden" name="board_id" value="${board_id}">
							<input type="hidden" id="rp_id" name="rp_id"
								value="${rpVo.rp_id }">
							<input type="hidden" class="form-control" id="rp_content"
								name="rp_content" value="${rpVo.rp_content }">
						<!-- ------------------------------------------------------ -->
							<c:choose>
								<c:when test="${'n' eq rpVo.rp_dl}">
									<div class="col-sm-6">
									<label class="control-label">${rpVo.rp_content}</label>
									</div>
									<div class="col-sm-2">
										<label class="control-label">[${rpVo.std_id} / <fmt:formatDate
												value="${rpVo.rp_date }" pattern="yyyy-MM-dd" />]
										</label>
									</div>
									<div class="col-sm-2">
										<input type="submit" class="btn btn-default" id="delReply"
											value="삭제">
									</div>
								</c:when>
								<c:otherwise>
									<div class="col-sm-6">
										<label class="control-label">[삭제 된 게시글 입니다.]</label>
									</div>
									<div class="col-sm-2">
										<label class="control-label">[${rpVo.std_id} / <fmt:formatDate
												value="${rpVo.rp_date }" pattern="yyyy-MM-dd" />]
										</label>
									</div>
									<div class="col-sm-2">
										<label class="control-label"></label>
									</div>
								</c:otherwise>
								</c:choose>
							<!-- -------------첫번째 댓글-------------------------- -->
						</form>
						</div>
					</c:forEach>
					
						<!-- -------------두번째 댓글----------------------------------------- -->
					<c:forEach items="${replyList}" var="rpVo" begin="1">
					<div class="form-group">
						<div class="col-sm-2">
							<label class="control-label"></label>
						</div>
						<!-- ------------------------------------------------------ -->
						<form method="post" action="/replyDelete" class="form-horizontal">
							<input type="hidden" id="id" name="id" value="${WriteVo.wr_id }">
							<input type="hidden" name="board_id" value="${board_id}">
							<input type="hidden" id="rp_id" name="rp_id"
								value="${rpVo.rp_id }">
							<input type="hidden" class="form-control" id="rp_content"
								name="rp_content" value="${rpVo.rp_content }">
						<!-- ------------------------------------------------------ -->
							<c:choose>
								<c:when test="${'n' eq rpVo.rp_dl}">
									<div class="col-sm-6">
									<label class="control-label">${rpVo.rp_content}</label>
									</div>
									<div class="col-sm-2">
										<label class="control-label">[${rpVo.std_id} / <fmt:formatDate
												value="${rpVo.rp_date }" pattern="yyyy-MM-dd" />]
										</label>
									</div>
									<div class="col-sm-2">
										<input type="submit" class="btn btn-default" id="delReply"
											value="삭제">
									</div>
								</c:when>
								<c:otherwise>
									<label class="col-sm-2 control-label"></label>
									<div class="col-sm-6">
										<label class="control-label">[삭제 된 게시글 입니다.]</label>
									</div>
									<div class="col-sm-2">
										<label class="control-label">[${rpVo.std_id} / <fmt:formatDate
												value="${rpVo.rp_date }" pattern="yyyy-MM-dd" />]
										</label>
									</div>
									<div class="col-sm-2">
										<label class="control-label"></label>
									</div>
								</c:otherwise>
							</c:choose>
							
							
							
						</form>
						</div>
					</c:forEach>
					
					<!-- ------------------댓글 출력 및 삭제 이벤트------------------------ -->
					
					
					
				<div class="form-group">
				<label class="col-sm-10 control-label"></label>
				</div>
				<form id="frm2" action="/ReplyServlet" name="replyForm"
					method="post" class="form-horizontal" role="form">
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label"></label>
						<div class="col-sm-8">
							<textarea rows="3" cols="30" id="replyInput" name="replyInput"
								class="form-control" maxlength="500" onKeyDown="onKeyDown();"></textarea>
							<input type="hidden" name="board_id" value="${board_id}">
							<input type="hidden" name="wr_id" value="${WriteVo.wr_id }">
						</div>
						<div class="col-sm-2">
							<input type="submit" id="replyBtn" name="replyBtn"
								class="btn btn-default" value="댓글 저장">
						</div>
					</div>
				</form>
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
 
    if (val == "update") {
        form.action = "/wrtieUpdateMove";
    } else if (val == "delete") {
        form.action = "/writeDelete";
    } else if (val == "reply") {
        form.action = "/writeReplyMove";
    } else {
        return false;
    }
    form.submit();
}

function onKeyDown()
{
     if(event.keyCode == 13)
     {
    	 $("#frm2").submit();
     }
}

</script>
</html>
