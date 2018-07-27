package kr.or.ddit.newBoard.service;

import java.util.List;

import kr.or.ddit.newBoard.dao.NewBoardDao;
import kr.or.ddit.newBoard.dao.NewBoardDaoInf;
import kr.or.ddit.newBoard.model.NewBoardVo;

public class NewBoardService implements NewBoardServiceInf{
	
	private NewBoardDaoInf dao = new NewBoardDao();
	
	/**
	* Method : getAllNewBoard
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC20
	* 변경이력 :
	* @return
	* Method 설명 : 게시판의 모든정보를 가져오는 메서드
	*/
	@Override
	public List<NewBoardVo> getAllNewBoard() {
		return dao.getAllNewBoard();
	}

	@Override
	public int insertNewBoard(NewBoardVo nbVo) {
		return dao.insertNewBoard(nbVo);
	}

	@Override
	public int updateBoard(NewBoardVo nbVo) {
		return dao.updateBoard(nbVo);
	}
	
}
