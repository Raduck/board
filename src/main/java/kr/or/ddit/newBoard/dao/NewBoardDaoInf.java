package kr.or.ddit.newBoard.dao;

import java.util.List;

import kr.or.ddit.newBoard.model.NewBoardVo;

public interface NewBoardDaoInf {

	/**
	* Method : getBoardName
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC20
	* 변경이력 :
	* @return
	* Method 설명 :
	*/
	List<NewBoardVo> getAllNewBoard();
	
	/**
	* Method : insertBoard
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC20
	* 변경이력 :
	* @param nvo
	* @return
	* Method 설명 : 새 게시판 생성하는 메서드
	*/
	int insertNewBoard(NewBoardVo nbVo);
	
	/**
	* Method : updateBoard
	* 최초작성일 : 2018. 7. 21.
	* 작성자 : PC20
	* 변경이력 :
	* @param nbvo
	* @return
	* Method 설명 :
	*/
	int updateBoard(NewBoardVo nbVo);
}
