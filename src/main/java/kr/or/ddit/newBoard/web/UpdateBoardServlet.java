package kr.or.ddit.newBoard.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.newBoard.model.NewBoardVo;
import kr.or.ddit.newBoard.service.NewBoardService;
import kr.or.ddit.newBoard.service.NewBoardServiceInf;

/**
 * Servlet implementation class Cha
 */
@WebServlet("/UpdateBoard")
public class UpdateBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewBoardServiceInf service = new NewBoardService();
		request.setCharacterEncoding("UTF-8");
		NewBoardVo nbVo = new NewBoardVo();
				int board_id = Integer.parseInt(request.getParameter("board_id"));
		if(board_id==0){
			System.out.println("board_id 호출 실패////////////////////////////////////////////");
		}
		nbVo.setBoard_id(board_id);
		nbVo.setBoard_title(request.getParameter("updateBoardTitle"));
		nbVo.setBoard_use(request.getParameter("useable"));
		nbVo.setStd_id(request.getSession().getAttribute("id")+"");
		
		System.out.println(nbVo);
		
		int result = service.updateBoard(nbVo);
		//어플리케이션
		List<NewBoardVo> nbl = service.getAllNewBoard();
		ServletContext application = this.getServletContext();
		application.setAttribute("newBoardList", nbl);
		
		response.sendRedirect("/A_jsp/boardCreate.jsp?result="+result);
		
	}

}
