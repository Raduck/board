package kr.or.ddit.write.model;

import java.util.Date;

public class WriteVo {
	private int wr_id;
	private int board_id;
	private int wr_pno;
	private String wr_content;
	private String wr_title;
	private Date wr_date;
	private String wr_dl;
	private int wr_gno;
	private String std_id;
	
	
	public int getWr_id() {
		return wr_id;
	}
	public void setWr_id(int wr_id) {
		this.wr_id = wr_id;
	}
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public int getWr_pno() {
		return wr_pno;
	}
	public void setWr_pno(int wr_pno) {
		this.wr_pno = wr_pno;
	}
	public String getWr_content() {
		return wr_content;
	}
	public void setWr_content(String wr_content) {
		this.wr_content = wr_content;
	}
	public String getWr_title() {
		return wr_title;
	}
	public void setWr_title(String wr_title) {
		this.wr_title = wr_title;
	}
	public Date getWr_date() {
		return wr_date;
	}
	public void setWr_date(Date wt_date) {
		this.wr_date = wt_date;
	}
	public String getWr_dl() {
		return wr_dl;
	}
	public void setWr_dl(String wr_dl) {
		this.wr_dl = wr_dl;
	}
	public int getWr_gno() {
		return wr_gno;
	}
	public void setWr_gno(int wr_gno) {
		this.wr_gno = wr_gno;
	}
	public String getStd_id() {
		return std_id;
	}
	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}
	@Override
	public String toString() {
		return "WriteVo [wr_id=" + wr_id + ", board_id=" + board_id
				+ ", wr_pno=" + wr_pno + ", wr_content=" + wr_content
				+ ", wr_title=" + wr_title + ", wr_date=" + wr_date
				+ ", wr_dl=" + wr_dl + ", wr_gno=" + wr_gno + ", std_id="
				+ std_id + "]";
	}
	
	
	
}
