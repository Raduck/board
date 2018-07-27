package kr.or.ddit.write.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.write.service.WriteService;
import kr.or.ddit.write.service.WriteServiceInf;

/**
 * Servlet implementation class WriteDelete
 */
@WebServlet("/writeDelete")
public class WriteDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WriteServiceInf service = new WriteService();
		
		int wr_id = Integer.parseInt(request.getParameter("wr_id"));
		
		//처리후 이동할 게시판의 아이디
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		
		service.deleteWrite(wr_id);
		
		response.sendRedirect("/WriteServlet?board_id="+board_id+"&page=1&pageSize=10");
	}

}
