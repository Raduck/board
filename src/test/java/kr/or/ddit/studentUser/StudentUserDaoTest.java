package kr.or.ddit.studentUser;

import static org.junit.Assert.*;
import kr.or.ddit.studentUser.dao.StudentUserDao;
import kr.or.ddit.studentUser.dao.StudentUserDaoInf;
import kr.or.ddit.studentUser.model.StudentUserVo;

import org.junit.Before;
import org.junit.Test;

public class StudentUserDaoTest {
	
	private StudentUserDaoInf studentUserDao;
	
	@Before
	public void setUp() {
		studentUserDao= new StudentUserDao();

	}
	
	@Test
	public void getUser() {
		/***Given***/
		String std_id = "lhyun";

		/***When***/
		StudentUserVo stdvo = studentUserDao.getUser(std_id);
		/***Then***/
		assertEquals("lhyun", stdvo.getStd_id());
		assertEquals("1234", stdvo.getPass());
	}

}
