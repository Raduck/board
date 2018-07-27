package kr.or.ddit.reply.service;

import java.util.List;

import kr.or.ddit.reply.model.ReplyVo;

public interface ReplyServiceInf {
	
	/**
	* Method : getReplyInfo
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC20
	* 변경이력 :
	* @param wr_id
	* @return
	* Method 설명 : 게시글 아이디를 통해 해당 게시글의 댓글정보를 가져오는 메서드
	*/
	List<ReplyVo> getReplyInfo(int wr_id);
	
	/**
	* Method : insertNewReply
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC20
	* 변경이력 :
	* @param rpVo
	* Method 설명 : 새 댓글을 삽입하는 메서드
	*/
	void insertNewReply(ReplyVo rpVo);
	
	/**
	* Method : deleteReply
	* 최초작성일 : 2018. 7. 26.
	* 작성자 : PC20
	* 변경이력 :
	* @param rp_dl
	* Method 설명 :
	*/
	void deleteReply(int rp_id);
}
