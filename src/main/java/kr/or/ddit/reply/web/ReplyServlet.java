package kr.or.ddit.reply.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.reply.model.ReplyVo;
import kr.or.ddit.reply.service.ReplyService;
import kr.or.ddit.reply.service.ReplyServiceInf;

/**
 * Servlet implementation class ReplyServlet
 */
@WebServlet("/ReplyServlet")
public class ReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
		ReplyServiceInf service = new ReplyService();
		String board_id = request.getParameter("board_id");
		String rp_content = request.getParameter("replyInput");
		int wr_id = Integer.parseInt(request.getParameter("wr_id"));
		ReplyVo rpVo = new ReplyVo();
		rpVo.setRp_dl("n");
		rpVo.setRp_content(rp_content);
		rpVo.setStd_id((String)request.getSession().getAttribute("id"));
		rpVo.setWr_id(wr_id);
		service.insertNewReply(rpVo);
		
		response.sendRedirect("/WriteDetail?board_id="+board_id+"&wr_id="+wr_id);
	}

}
