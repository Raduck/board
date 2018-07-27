package kr.or.ddit.reply.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.reply.service.ReplyService;
import kr.or.ddit.reply.service.ReplyServiceInf;

/**
 * Servlet implementation class ReplyDeleteServlet
 */
@WebServlet("/replyDelete")
public class ReplyDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReplyServiceInf service = new ReplyService();
		
		int rp_id = Integer.parseInt(request.getParameter("rp_id"));
		
		//처리후 이동할 게시판의 아이디
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		
		service.deleteReply(rp_id);
		
		response.sendRedirect("/WriteServlet?board_id="+board_id+"&page=1&pageSize=10");
	}

}
