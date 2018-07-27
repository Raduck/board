package kr.or.ddit.upload.service;

import java.util.List;

import kr.or.ddit.upload.model.UploadVo;

public interface UploadFileServiceInf {
	
	/**
	* Method : uploadFile
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC20
	* 변경이력 :
	* @param ulVo
	* Method 설명 : 파일을 업로드 하는 메서드
	*/
	void uploadFile(UploadVo ulVo);
	
	/**
	* Method : selectAllFile
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC20
	* 변경이력 :
	* @param uploadWr_id
	* @return
	* Method 설명 : 게시판 번호를 통해 업로드 파일 모두 호출
	*/
	List<UploadVo> selectAllFile(int uploadWr_id);
	
	/**
	* Method : deleteFile
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : PC20
	* 변경이력 :
	* @param wr_id
	* Method 설명 : 게시글 번호를 통해 첨부파일을 업데이트하기 위해 임시 삭제하는 메서드
	*/
	void deleteFile(int wr_id);
}
