package kr.or.ddit.login;

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
import kr.or.ddit.studentUser.model.StudentUserVo;
import kr.or.ddit.studentUser.service.StudentUserService;
import kr.or.ddit.studentUser.service.StudentUserServiceInf;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String std_id = request.getParameter("std_id");
		String pass = request.getParameter("pass");
	
		//
		StudentUserServiceInf stdUserService = new StudentUserService();
		StudentUserVo stdvo = stdUserService.getUser(std_id);
		if(stdvo==null){
			request.getRequestDispatcher("/A_jsp/login.jsp").forward(request, response);
			
		}else{
			if(stdvo.validData(std_id, pass)){
				//리퀘스트에 세팅 응답을 하고나면 사라짐
				request.setAttribute("id", request.getParameter("std_id"));
	 			request.setAttribute("pass", request.getParameter("pass"));
	 			
	 			//어플리케이션
	 			NewBoardServiceInf service = new NewBoardService();
	 			List<NewBoardVo> nbl = service.getAllNewBoard();
	 			ServletContext application = this.getServletContext();
	 			application.setAttribute("newBoardList", nbl);
	 			
	 			request.getSession().setAttribute("userVo", stdvo);
	 			request.getSession().setAttribute("id", stdvo.getStd_id());
	 			request.getSession().setAttribute("pass", stdvo.getPass());
	 			request.getRequestDispatcher("/A_jsp/main.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("/A_jsp/login.jsp").forward(request, response);
			}
		}
		
	}

}
