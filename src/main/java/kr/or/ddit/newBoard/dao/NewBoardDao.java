package kr.or.ddit.newBoard.dao;

import java.util.List;

import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.newBoard.model.NewBoardVo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class NewBoardDao implements NewBoardDaoInf{
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	
	@Override
	public List<NewBoardVo> getAllNewBoard() {
		SqlSession session = sqlSessionFactory.openSession();
		List<NewBoardVo> nbl = session.selectList("newBoard.getAllNewBoard");
		session.close();
		return nbl;
	}

	@Override
	public int insertNewBoard(NewBoardVo nbVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int result = session.insert("newBoard.insertNewBoard",nbVo);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public int updateBoard(NewBoardVo nbVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int result = session.update("newBoard.updateBoard", nbVo);
		session.commit();
		session.close();
		return result;
	}
	
}
