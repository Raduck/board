package kr.or.ddit.reply.model;

import java.util.Date;

public class ReplyVo {
	private int rp_id;
	private String rp_content;
	private Date rp_date;
	private int wr_id;
	private String std_id;
	private String rp_dl;
	
	
	public int getRp_id() {
		return rp_id;
	}
	public void setRp_id(int rp_id) {
		this.rp_id = rp_id;
	}
	public String getRp_content() {
		return rp_content;
	}
	public void setRp_content(String rp_content) {
		this.rp_content = rp_content;
	}
	public Date getRp_date() {
		return rp_date;
	}
	public void setRp_date(Date rp_date) {
		this.rp_date = rp_date;
	}
	public int getWr_id() {
		return wr_id;
	}
	public void setWr_id(int wr_id) {
		this.wr_id = wr_id;
	}
	public String getStd_id() {
		return std_id;
	}
	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}
	public String getRp_dl() {
		return rp_dl;
	}
	public void setRp_dl(String rp_dl) {
		this.rp_dl = rp_dl;
	}
	@Override
	public String toString() {
		return "ReplyVo [rp_id=" + rp_id + ", rp_content=" + rp_content
				+ ", rp_date=" + rp_date + ", wr_id=" + wr_id + ", std_id="
				+ std_id + ", rp_dl=" + rp_dl + "]";
	}
	
	
	
}
