package kr.or.ddit.write;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.write.dao.WriteDao;
import kr.or.ddit.write.dao.WriteDaoInf;
import kr.or.ddit.write.model.WriteVo;

import org.junit.Before;
import org.junit.Test;

public class WriteDaoTest {
	private static final int HashMap = 0;
	private WriteDaoInf dao;
	
	@Before
	public void setUp() {
		dao = new WriteDao();
	}
	
	

	@Test
	public void getAllWrite() {
		/***Given***/
		int board_no = 1;

		/***When***/
		List<WriteVo> wrl = dao.getAllWrite(board_no);
		/***Then***/
		assertEquals(1, wrl.size());
	}
	
	@Test
	public void getWriteTitle() {
		/***Given***/
		int board_no = 1;

		/***When***/
		List<String> wrl = dao.getWriteTitle(board_no);
		System.out.println(wrl);
		/***Then***/
		assertEquals(1, wrl.size());
	}
	
	@Test
	public void getWriteTotCnt(){
		/***Given***/
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("board_id", 1);
		/***When***/
		int result = dao.getWriteTotCnt(map);
		/***Then***/
		assertEquals(13, result);
	}
	
	@Test
	public void getWritePageList(){
		/***Given***/
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("page", 1);
		paramMap.put("pageSize", 10);

		/***When***/
		List<WriteVo> wrl = dao.getWritePageList(paramMap);
		/***Then***/
		assertEquals(1, wrl.size());
	}
}
