package kr.or.ddit.newBoard.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.newBoard.model.NewBoardVo;
import kr.or.ddit.newBoard.service.NewBoardService;
import kr.or.ddit.newBoard.service.NewBoardServiceInf;

/**
 * Servlet implementation class NewBoardServlet
 */
@WebServlet("/NewBoard")
public class NewBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(NewBoardServlet.class);
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewBoardServiceInf service = new NewBoardService();

		String board_title = request.getParameter("newBoardTitle");
		String board_use = request.getParameter("useable");
		String std_id = (String) request.getSession().getAttribute("id");

		
		NewBoardVo nbVo = new NewBoardVo();
		nbVo.setStd_id(std_id);
		nbVo.setBoard_title(board_title);
		nbVo.setBoard_use(board_use);
		int resultInsert = service.insertNewBoard(nbVo);
		
		
		logger.debug(board_title+board_use+std_id);
		//request.getRequestDispatcher("/A_jsp/boardCreate.jsp").forward(request, response);
		List<NewBoardVo> nbl = service.getAllNewBoard();
		ServletContext application = this.getServletContext();
		application.setAttribute("newBoardList", nbl);
		
		response.sendRedirect("/A_jsp/main.jsp?resultInsert="+resultInsert);
	}
		

}
