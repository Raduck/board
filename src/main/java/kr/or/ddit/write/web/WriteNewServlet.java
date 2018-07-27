package kr.or.ddit.write.web;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.file.FileUtil;
import kr.or.ddit.upload.model.UploadVo;
import kr.or.ddit.upload.service.UploadFileService;
import kr.or.ddit.upload.service.UploadFileServiceInf;
import kr.or.ddit.write.model.WriteVo;
import kr.or.ddit.write.service.WriteService;
import kr.or.ddit.write.service.WriteServiceInf;

/**
 * Servlet implementation class WriteNewServlet
 */
@WebServlet("/writeNew")
@MultipartConfig(maxFileSize = 1024 * 1000 * 3, maxRequestSize = 1024 * 1000 * 15)
public class WriteNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("board_id",
				Integer.parseInt(request.getParameter("board_id")));
		request.getRequestDispatcher("/newBoardWrite/writeNew.jsp").forward(
				request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		WriteServiceInf service = new WriteService();
		UploadFileServiceInf service2 = new UploadFileService();
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		String wr_title = request.getParameter("wr_title");
		String wr_content = request.getParameter("wr_content");
		String std_id = (String) request.getSession().getAttribute("id");
		WriteVo wrVo = new WriteVo();
		wrVo.setBoard_id(board_id);
		wrVo.setWr_title(wr_title);
		wrVo.setWr_content(wr_content);
		wrVo.setStd_id(std_id);
		wrVo.setWr_dl("n");
		// wrVo.setWr_pno(wr_pno);
		// wrVo.setWr_gno(wr_gno);
		service.insertNewWrite(wrVo);

		int uploadWr_id = service.selectWr_id(wrVo);
		// /////////////////////게시글
		
		Collection<Part> parts = request.getParts();

		for (Part part : parts) {
			if (part.getContentType() != null) {

				String contentDisposition = part
						.getHeader("Content-Disposition");
				String fileName = FileUtil.getFileName(contentDisposition);

				if (part.getSize() > 0) {
					System.out
							.println("=-=====================================================");
					// 해당 경로에 파일 업로드를 시작한 하 파트를 딜리트 한다.
					String path = FileUtil.fileUploadPath;
					String file_nm = UUID.randomUUID().toString();
					String file_path = path + File.separator + file_nm;
					part.write(file_path);
					part.delete();

					if (!fileName.equals(null)) {
						// 이름이 null이 아니면 첨부파일 테이블에 인서트 작업을 시행한다.
						UploadVo ulVo = new UploadVo();
						ulVo.setFile_nm(file_nm);
						ulVo.setFile_path(path);
						ulVo.setFile_upnm(fileName);
						ulVo.setWr_id(uploadWr_id);
						service2.uploadFile(ulVo);
					}
				}
			}

		}

		response.sendRedirect("/WriteServlet?board_id=" + board_id);

	}

}
