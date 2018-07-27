package kr.or.ddit.write.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WriteReplyMoveServlet
 */
@WebServlet("/writeReplyMove")
public class WriteReplyMoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("wr_id", request.getParameter("wr_id"));
		request.setAttribute("board_id", request.getParameter("board_id"));
		request.getRequestDispatcher("/newBoardWrite/writeReply.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
