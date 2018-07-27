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
 * Servlet implementation class WrtieUpdateMoveServlet
 */
@WebServlet("/wrtieUpdateMove")
public class WrtieUpdateMoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//detail view 에서 WriteVo를 히든 셋 해준 후 가져오는 방법도 있다 ㅎㅎ
		WriteServiceInf service = new WriteService();
		int wr_id = Integer.parseInt(request.getParameter("wr_id"));
		WriteVo wrVo = service.getWriteDetail(wr_id);
		request.setAttribute("wrVo", wrVo);
		System.out.println(wrVo.getWr_content());
		/*request.setAttribute("board_id", request.getParameter("board_id"));
		request.setAttribute("wr_id", );
		request.setAttribute("wr_title", request.getParameter("wr_title"));
		request.setAttribute("wr_content", request.getParameter("wr_content"));*/
		request.getRequestDispatcher("/newBoardWrite/writeUpdate.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
