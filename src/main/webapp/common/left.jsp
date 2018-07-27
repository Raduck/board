<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="col-sm-3 col-md-2 sidebar">
   <ul class="nav nav-sidebar">
      <li class="active"><a href="/A_jsp/main.jsp">Main <span class="sr-only">(current)</span></a></li>
   	  <li class="active"><a href="/A_jsp/boardCreate.jsp">게시판 생성</a></li>
   	  <!-- <li class="active"><a href="/NewBoard">게시판</a></li> -->
   	  <c:forEach items="${newBoardList }" var="vo">
   	  <c:if test="${vo.board_use == 'y' }">
   	  <li class="active"><a href="/WriteServlet?board_id=${vo.board_id}&board_title=${vo.board_title}&page=1&pageSize=10">${vo.board_title}</a></li>
   	  </c:if>
   	  </c:forEach>
   </ul>
</div>
