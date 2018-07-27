package kr.or.ddit.studentUser.service;

import kr.or.ddit.studentUser.dao.StudentUserDao;
import kr.or.ddit.studentUser.dao.StudentUserDaoInf;
import kr.or.ddit.studentUser.model.StudentUserVo;

public class StudentUserService implements StudentUserServiceInf{
	private StudentUserDaoInf dao = new StudentUserDao();
	
	
	/**
	* Method : getUser
	* 최초작성일 : 2018. 7. 18.
	* 작성자 : PC20
	* 변경이력 :
	* @param std_id
	* @return
	* Method 설명 : 학생의 아이디로 모든 정보를 가져오는 메서드
	*/
	@Override
	public StudentUserVo getUser(String std_id) {
		return dao.getUser(std_id);
	}
	
}
