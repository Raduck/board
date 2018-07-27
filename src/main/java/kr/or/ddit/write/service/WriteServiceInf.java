package kr.or.ddit.write.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.write.model.WriteVo;

public interface WriteServiceInf {
	
	/**
	 * Method : getWriteTitle
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : PC20
	 * 변경이력 :
	 * @param board_no
	 * @return
	 * Method 설명 : 게시판 번호로 모든 게시글의 타이틀 정보를 가져오는 메서드
	 */
	List<String> getWriteTitle(int board_id);
	
	/**
	* Method : getAllWrite
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC20
	* 변경이력 :
	* @param board_no
	* @return
	* Method 설명 : 게시판 번호로 모든 게시글의 정보를 가져오는 메서드
	*/
	List<WriteVo> getAllWrite(int board_id);
	
	
	/**
	* Method : getWritePageList
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC20
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : 게시글 페이지 리스트 조회
	*/
	Map<String, Object> getWritePageList(Map<String, Integer> map);
	
	/**
	* Method : getWriteDetail
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC20
	* 변경이력 :
	* @param wr_id
	* @return
	* Method 설명 : 게시글 번호로 게시글의 정보를 가져오는 메서드
	*/
	WriteVo getWriteDetail(int wr_id);
	
	/**
	* Method : insertNewWrite
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC20
	* 변경이력 :
	* @param wrVo
	* Method 설명 : 새 글을 insert하는 메서드
	*/
	void insertNewWrite(WriteVo wrVo);
	
	/**
	* Method : deleteWrite
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC20
	* 변경이력 :
	* @param map wr_id 의 값과 std_id 의 값이 들어 있는 파라미터 맵
	* Method 설명 : wr_id와 std_id 가 일치하는 게시글 삭제여부를 y로 바꾸는 메서드
	*/
	void deleteWrite(int wr_id);
	
	/**
	* Method : updateWrite
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC20
	* 변경이력 :
	* @param wrVo
	* Method 설명 : WriteVo 객체를 파라미터값으로 게시글을 update 하는 메서드
	*/
	void updateWrite(WriteVo wrVo);
	
	/**
	* Method : insertNewReplyWrite
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC20
	* 변경이력 :
	* @param wrVo
	* Method 설명 : 답글 쓰기 메서드
	*/
	void insertNewReplyWrite(WriteVo wrVo);
	
	/**
	* Method : selectWr_id
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC20
	* 변경이력 :
	* @param wrVo
	* @return
	* Method 설명 : 새 글을 쓸 때 첨부파일을 저장할 게시글번호를 찾는 메서드
	*/
	int selectWr_id(WriteVo wrVo);
}
