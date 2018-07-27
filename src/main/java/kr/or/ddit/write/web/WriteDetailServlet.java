package kr.or.ddit.write.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.reply.model.ReplyVo;
import kr.or.ddit.reply.service.ReplyService;
import kr.or.ddit.reply.service.ReplyServiceInf;
import kr.or.ddit.upload.model.UploadVo;
import kr.or.ddit.upload.service.UploadFileService;
import kr.or.ddit.upload.service.UploadFileServiceInf;
import kr.or.ddit.write.model.WriteVo;
import kr.or.ddit.write.service.WriteService;
import kr.or.ddit.write.service.WriteServiceInf;

/**
 * Servlet implementation class WriteDetailServlet
 */
@WebServlet("/WriteDetail")
public class WriteDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WriteServiceInf service = new WriteService();
		UploadFileServiceInf service2 = new UploadFileService();
		int wr_id = Integer.parseInt(request.getParameter("wr_id"));
		WriteVo wrVo = service.getWriteDetail(wr_id);
		
		request.setAttribute("WriteVo", wrVo);
		System.out.println("//////////////////////////////"+wrVo);
		
		//해당 게시글의 댓글을 검색하여 출력해야 한다.
		ReplyServiceInf rpService = new ReplyService();
		request.setAttribute("board_id", request.getParameter("board_id"));
		List<ReplyVo> rpList = rpService.getReplyInfo(wr_id);
		request.setAttribute("replyList", rpList);
		//해당 게시글의 첨부파일을 출력해야 한다..
		//List<UploadVo> uploadFileList = (List<UploadVo>) request.getAttribute("uploadFileList");
		
		//request.setAttribute("uploadFileList", request.getAttribute("uploadFileList"));
		
		// 자세히 보기에서 첨부파일 목록을 출력시켜주기 위한 작업을 한다.
	    List<UploadVo> uploadFileList = service2.selectAllFile(wr_id);
	    request.setAttribute("uploadFileList", uploadFileList);
		request.getRequestDispatcher("/newBoardWrite/writeDetail.jsp").forward(request, response);;
		
	}
	
}
