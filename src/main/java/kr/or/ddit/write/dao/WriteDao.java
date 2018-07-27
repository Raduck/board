package kr.or.ddit.write.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.write.model.WriteVo;

public class WriteDao implements WriteDaoInf{
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	
	@Override
	public List<String> getWriteTitle(int board_no) {
		SqlSession session = sqlSessionFactory.openSession();
		List<String> wrTitleList = session.selectList("write.getWriteTitle",board_no);
		session.close();
		return wrTitleList;
	}

	@Override
	public List<WriteVo> getAllWrite(int board_no) {
		SqlSession session = sqlSessionFactory.openSession();
		List<WriteVo> writeAll = session.selectList("write.getAllWrite",board_no);
		session.close();
		return writeAll;
	}

	@Override
	public List<WriteVo> getWritePageList(Map<String, Integer> map) {
		SqlSession session = sqlSessionFactory.openSession();
		List<WriteVo> writePageList = session.selectList("write.getWritePageList",map);
		session.close();
		return writePageList;
	}

	@Override
	public int getWriteTotCnt(Map<String, Integer> map) {
		SqlSession session = sqlSessionFactory.openSession();
		int result = session.selectOne("write.getWriteTotCnt",map);
		session.close();
		return result;
	}

	@Override
	public WriteVo getWriteDetail(int wr_id) {
		WriteVo wrVo = new WriteVo();
		SqlSession session = sqlSessionFactory.openSession();
		wrVo = session.selectOne("write.getWriteDetail", wr_id);
		session.close();
		return wrVo;
	}

	@Override
	public void insertNewWrite(WriteVo wrVo) {
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("write.insertNewWrite",wrVo);
		session.commit();
		session.close();
	}

	@Override
	public void deleteWrite(int wr_id) {
		SqlSession session = sqlSessionFactory.openSession();
		session.update("write.deleteWrite",wr_id);
		session.commit();
		session.close();
	}

	@Override
	public void updateWrite(WriteVo wrVo) {
		SqlSession session = sqlSessionFactory.openSession();
		System.out.println(wrVo.toString());
		session.update("write.updateWrite",wrVo);
		session.commit();
		session.close();
	}

	@Override
	public void insertNewReplyWrite(WriteVo wrVo) {
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("write.insertReplyWrite",wrVo);
		session.commit();
		session.close();
	}

	@Override
	public int selectWr_id(WriteVo wrVo) {
		SqlSession session = sqlSessionFactory.openSession();
		System.out.println(wrVo);
		int wr_id = session.selectOne("write.selectWr_id",wrVo);
		session.close();// TODO Auto-generated method stub
		return wr_id;
	}

}
