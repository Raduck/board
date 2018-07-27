package kr.or.ddit.reply.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.reply.model.ReplyVo;

public class ReplyDao implements ReplyDaoInf{
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	
	
	@Override
	public List<ReplyVo> getReplyInfo(int wr_id) {
		List<ReplyVo> rpList = new ArrayList<ReplyVo>();
		SqlSession session = sqlSessionFactory.openSession();
		rpList=session.selectList("reply.getReplyInfo", wr_id);
		session.close();
		return rpList;
	}


	@Override
	public void insertNewReply(ReplyVo rpVo) {
		SqlSession session = sqlSessionFactory.openSession();
		System.out.println(rpVo.toString());
		session.insert("reply.insertNewReply",rpVo);
		session.commit();
		session.close();
	}


	@Override
	public void deleteReply(int rp_id) {
		SqlSession session = sqlSessionFactory.openSession();
		session.update("reply.deleteReply",rp_id);
		session.commit();
		session.close();
	}

}
