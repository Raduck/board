package kr.or.ddit.newBoard;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.newBoard.dao.NewBoardDao;
import kr.or.ddit.newBoard.dao.NewBoardDaoInf;
import kr.or.ddit.newBoard.model.NewBoardVo;

import org.junit.Before;
import org.junit.Test;

public class NewBoardDaoTest {
	private NewBoardDaoInf dao;
	@Before
	public void setUp() {
		dao = new NewBoardDao();

	}
	
	@Test
	public void getAllNewBoard() {
		/***Given***/
		

		/***When***/
		List<NewBoardVo> nvl = dao.getAllNewBoard();
		/***Then***/
		assertEquals(3, nvl.size());
	}
	
	@Test
	public void insertNewBoard(){
		/***Given***/
		NewBoardVo nbVo = new NewBoardVo();
		nbVo.setBoard_title("세 번째 게시판");
		nbVo.setBoard_use("y");
		nbVo.setStd_id("lhyun");
		
		/***When***/
		int result = dao.insertNewBoard(nbVo);
		/***Then***/
		assertEquals(1, result);
		
	}

}
