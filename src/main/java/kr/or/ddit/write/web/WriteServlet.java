package kr.or.ddit.write.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.write.model.WriteVo;
import kr.or.ddit.write.service.WriteService;
import kr.or.ddit.write.service.WriteServiceInf;

/**
 * Servlet implementation class WriteServlet
 */
@WebServlet("/WriteServlet")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		
		WriteServiceInf servcie = new WriteService();
		//List<String> wrTitleList = servcie.getWriteTitle(board_id);
		//request.setAttribute("writeTitle", wrTitleList);
		//List<WriteVo> wrAll = servcie.getAllWrite(board_id);
		//request.setAttribute("wrAll", wrAll);
		
		String pageStr = request.getParameter("page");
		int page = pageStr == null? 1 : Integer.parseInt(pageStr);
		
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = pageSizeStr == null? 10 : Integer.parseInt(pageSizeStr);
		
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		paramMap.put("board_id", board_id);	
		
		Map<String, Object> resultMap = servcie.getWritePageList(paramMap);		
		
		List<WriteVo> writeList = (List<WriteVo>) resultMap.get("pageList");
		request.setAttribute("writeList", writeList);
		String pageNavi = (String) resultMap.get("pageNavi");
		request.setAttribute("pageNavi", pageNavi);
		
		request.setAttribute("board_id", board_id);
		
		request.getRequestDispatcher("/newBoardWrite/writeResult.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//새글쓰기 취소에서 넒어오는곳
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		
		WriteServiceInf servcie = new WriteService();
		//List<String> wrTitleList = servcie.getWriteTitle(board_id);
		//request.setAttribute("writeTitle", wrTitleList);
		//List<WriteVo> wrAll = servcie.getAllWrite(board_id);
		//request.setAttribute("wrAll", wrAll);
		
		String pageStr = request.getParameter("page");
		int page = pageStr == null? 1 : Integer.parseInt(pageStr);
		
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = pageSizeStr == null? 10 : Integer.parseInt(pageSizeStr);
		
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		paramMap.put("board_id", board_id);	
		
		Map<String, Object> resultMap = servcie.getWritePageList(paramMap);		
		
		List<WriteVo> writeList = (List<WriteVo>) resultMap.get("pageList");
		request.setAttribute("writeList", writeList);
		
		String pageNavi = (String) resultMap.get("pageNavi");
		request.setAttribute("pageNavi", pageNavi);
		
		request.setAttribute("board_id", board_id);
		
		request.getRequestDispatcher("/newBoardWrite/writeResult.jsp").forward(request, response);
	}

}
