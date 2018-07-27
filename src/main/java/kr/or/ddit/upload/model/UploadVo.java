package kr.or.ddit.upload.model;

public class UploadVo {
	private int file_id;
	private int wr_id;
	private String file_upnm;
	private String file_path;
	private String file_nm;
	
	
	
	public int getFile_id() {
		return file_id;
	}



	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}



	public int getWr_id() {
		return wr_id;
	}



	public void setWr_id(int wr_id) {
		this.wr_id = wr_id;
	}



	public String getFile_upnm() {
		return file_upnm;
	}



	public void setFile_upnm(String file_upnm) {
		this.file_upnm = file_upnm;
	}



	public String getFile_path() {
		return file_path;
	}



	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}



	public String getFile_nm() {
		return file_nm;
	}



	public void setFile_nm(String file_nm) {
		this.file_nm = file_nm;
	}



	@Override
	public String toString() {
		return "UploadVo [file_id=" + file_id + ", wr_id=" + wr_id
				+ ", file_upnm=" + file_upnm + ", file_path=" + file_path
				+ ", file_nm=" + file_nm + "]";
	}
	
	
}
