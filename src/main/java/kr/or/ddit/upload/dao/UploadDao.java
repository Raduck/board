package kr.or.ddit.upload.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.upload.model.UploadVo;

public class UploadDao implements UploadFileDaoInf{
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	
	@Override
	public void uploadFile(UploadVo ulVo) {
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("upload.uploadFile",ulVo);
		session.commit();
		session.close();
	}
	@Override
	public List<UploadVo> selectAllFile(int uploadWr_id) {
		SqlSession session = sqlSessionFactory.openSession();
		List<UploadVo> ulvoList = session.selectList("upload.selectAllFile",uploadWr_id);
		session.close();
		return ulvoList;
	}
	@Override
	public void deleteFile(int wr_id) {
		SqlSession session = sqlSessionFactory.openSession();
		session.delete("upload.deleteFile",wr_id);
		session.close();
	}

}
