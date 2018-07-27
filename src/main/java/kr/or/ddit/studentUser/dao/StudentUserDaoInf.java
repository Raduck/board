package kr.or.ddit.studentUser.dao;

import kr.or.ddit.studentUser.model.StudentUserVo;

public interface StudentUserDaoInf {
	/**
	* Method : getUser
	* 최초작성일 : 2018. 7. 4.
	* 작성자 : PC20
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 :
	*/
	public StudentUserVo getUser(String std_id);
}
