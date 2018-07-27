package kr.or.ddit.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.studentUser.model.StudentUserVo;
import kr.or.ddit.studentUser.service.StudentUserService;
import kr.or.ddit.studentUser.service.StudentUserServiceInf;

/**
 * Servlet implementation class FileDownLoadServlet
 */
@WebServlet("/pic")
public class PicDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// <img src="/pic?id=2"/>
		String id = (String) request.getSession().getAttribute("id");
		
		//물리 파일명을 이용하여 사진 다운로드 부터 진행
		
		// 사용자 정보 조회
		StudentUserServiceInf studentService = new StudentUserService();
		StudentUserVo studentVo = studentService.getUser(id);
		
		
		response.setHeader("Content-Disposition", "attachment; filename=\""+studentVo.getPic()+ "\"");
		response.setContentType("application/octet-stream");
		
		//FileUtil.fileUPloadPath : sally.png
		//파라미터로 파일명 제공
		// /fileDownLoad?fileName = sally.png
		//String fileName = request.getParameter("fileName");
		
		
	    String file = studentVo.getPicpath()+File.separator+studentVo.getPicname();
	    
	    //file 입출력을 위한 준비
	    ServletOutputStream sos =  response.getOutputStream();
	    
	    File f = new File(file);
	    FileInputStream fis = new FileInputStream(f);
	    byte[] b = new byte[512];
	    int len = 0;
	    while((len = fis.read(b))!=-1){
	    	sos.write(b, 0, len);
	    }
	    sos.close();
	    fis.close();
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
