package kr.or.ddit.upload.service;

import java.util.List;

import kr.or.ddit.upload.dao.UploadDao;
import kr.or.ddit.upload.dao.UploadFileDaoInf;
import kr.or.ddit.upload.model.UploadVo;

public class UploadFileService implements UploadFileServiceInf {
	
	private UploadFileDaoInf dao = new UploadDao();	
	
	@Override
	public void uploadFile(UploadVo ulVo) {
		dao.uploadFile(ulVo);
	}

	@Override
	public List<UploadVo> selectAllFile(int uploadWr_id) {
		return dao.selectAllFile(uploadWr_id);
	}

	@Override
	public void deleteFile(int wr_id) {
		dao.deleteFile(wr_id);
	}

}
