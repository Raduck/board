package kr.or.ddit.reply.service;

import java.util.List;

import kr.or.ddit.reply.dao.ReplyDao;
import kr.or.ddit.reply.dao.ReplyDaoInf;
import kr.or.ddit.reply.model.ReplyVo;

public class ReplyService implements ReplyServiceInf{
	private ReplyDaoInf dao = new ReplyDao();
	
	@Override
	public List<ReplyVo> getReplyInfo(int wr_id) {
		return dao.getReplyInfo(wr_id);
	}

	@Override
	public void insertNewReply(ReplyVo rpVo) {
		dao.insertNewReply(rpVo);
	}

	@Override
	public void deleteReply(int rp_id) {
		dao.deleteReply(rp_id);
	}

}
