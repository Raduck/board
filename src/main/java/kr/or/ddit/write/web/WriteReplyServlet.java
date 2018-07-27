package kr.or.ddit.write.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.write.model.WriteVo;
import kr.or.ddit.write.service.WriteService;
import kr.or.ddit.write.service.WriteServiceInf;

/**
 * Servlet implementation class WriteReplyServlet
 */
@WebServlet("/writeReply")
public class WriteReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		WriteServiceInf service = new WriteService();
		
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		int wr_id = Integer.parseInt(request.getParameter("wr_id"));
		String wr_title = request.getParameter("wr_title");
		String wr_content = request.getParameter("wr_content");
		String std_id = (String) request.getSession().getAttribute("id");
		WriteVo wrVo = new WriteVo();
		wrVo.setBoard_id(board_id);
		wrVo.setWr_title(wr_title);
		wrVo.setWr_content(wr_content);
		wrVo.setStd_id(std_id);
		wrVo.setWr_dl("n");
		wrVo.setWr_pno(wr_id);
		int wr_gno = service.getWriteDetail(wr_id).getWr_gno();
		wrVo.setWr_gno(wr_gno);
		
		service.insertNewReplyWrite(wrVo);
		
		response.sendRedirect("/WriteServlet?board_id="+board_id+"&page=1&pageSize=10");
	}

}
