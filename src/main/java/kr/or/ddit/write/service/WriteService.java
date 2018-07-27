package kr.or.ddit.write.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.write.dao.WriteDao;
import kr.or.ddit.write.dao.WriteDaoInf;
import kr.or.ddit.write.model.WriteVo;

public class WriteService implements WriteServiceInf{
	private WriteDaoInf dao = new WriteDao();
	@Override
	public List<String> getWriteTitle(int board_id) {
		return dao.getWriteTitle(board_id);
	}

	@Override
	public List<WriteVo> getAllWrite(int board_id) {
		return dao.getAllWrite(board_id);
	}

	@Override
	public Map<String, Object> getWritePageList(Map<String, Integer> map) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		// 페이지 리스트 조회
		List<WriteVo> pageList = dao.getWritePageList(map);
		resultMap.put("pageList", pageList);
		
		// 전체 건수 조회
		int totCnt = dao.getWriteTotCnt(map);
		resultMap.put("totCnt", totCnt);
		
		// 페이지 네비게이션 html 생성
		int page = map.get("page");
		int pageSize = map.get("pageSize");
		
		// board_id
		int board_id = map.get("board_id");
		
		resultMap.put("pageNavi", makePageNavi(page, pageSize, totCnt, board_id));
		
		return resultMap;
	}
	
	private String makePageNavi(int page, int pageSize, int totCnt, int board_id){
		int cnt = totCnt / pageSize;	//몫
		int mod = totCnt % pageSize;	//나머지
		
		if (mod > 0) {
			cnt++;
		}
		
		StringBuffer pageNaviStr = new StringBuffer();
		
		int prevPage = page == 1 ? 1 : page-1;
		int nextPage = page == cnt ? page : page+1;
		pageNaviStr.append("<li><a href=\"/WriteServlet?board_id="+board_id+"&page=" + 1 + "&pageSize=" + pageSize + "\" aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a></li>");
		pageNaviStr.append("<li><a href=\"/WriteServlet?board_id="+board_id+"&page=" + prevPage + "&pageSize=" + pageSize + "\" aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a></li>");
		
		//for(int i = 0; i < cnt; i++)
		for (int i = 1; i <= cnt; i++) {
			//WriteServlet?page=3&pageSize=10
			String activeClass = "";
		if ( i == page) 
			activeClass = "class=\"active\"";
			pageNaviStr.append("<li " + activeClass + "><a href=\"/WriteServlet?board_id="+board_id+"&page=" + i +
					"&pageSize=" + pageSize + "\">" + i + "</a></li>");
		
//			else {
//			pageNaviStr.append("<li><a href=\"/WriteServlet?page=" + i +
//					"&pageSize=" + pageSize + "\">" + i + "</a></li>");
//		}
			
		}
		
		pageNaviStr.append("<li><a href=\"/WriteServlet?board_id="+board_id+"&page=" + nextPage + "&pageSize=" + pageSize + "\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>");
		pageNaviStr.append("<li><a href=\"/WriteServlet?board_id="+board_id+"&page=" + cnt + "&pageSize=" + pageSize + "\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>");
		return pageNaviStr.toString();
	}

	@Override
	public WriteVo getWriteDetail(int wr_id) {
		return dao.getWriteDetail(wr_id);
	}

	@Override
	public void insertNewWrite(WriteVo wrVo) {
		dao.insertNewWrite(wrVo);
	}

	@Override
	public void deleteWrite(int wr_id) {
		dao.deleteWrite(wr_id);
	}

	@Override
	public void updateWrite(WriteVo wrVo) {
		dao.updateWrite(wrVo);
	}

	@Override
	public void insertNewReplyWrite(WriteVo wrVo) {
		dao.insertNewReplyWrite(wrVo);
	}

	@Override
	public int selectWr_id(WriteVo wrVo) {
		return dao.selectWr_id(wrVo);
	}
	
}
