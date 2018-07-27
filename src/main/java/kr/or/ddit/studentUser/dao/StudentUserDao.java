package kr.or.ddit.studentUser.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.studentUser.model.StudentUserVo;

public class StudentUserDao implements StudentUserDaoInf{
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	@Override
	public StudentUserVo getUser(String std_id) {
		SqlSession session = sqlSessionFactory.openSession();
		StudentUserVo svo = session.selectOne("student.getUser",std_id);
		session.close();
		return svo;
	}

}
