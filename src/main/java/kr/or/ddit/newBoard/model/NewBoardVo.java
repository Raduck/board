package kr.or.ddit.newBoard.model;

import java.util.Date;

public class NewBoardVo {
	private int board_id;
	private String board_title;
	private String board_use;
	private Date board_dt;
	private String std_id;
	
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_use() {
		return board_use;
	}
	public void setBoard_use(String board_use) {
		this.board_use = board_use;
	}
	public Date getBoard_dt() {
		return board_dt;
	}
	public void setBoard_dt(Date board_dt) {
		this.board_dt = board_dt;
	}
	public String getStd_id() {
		return std_id;
	}
	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}
	
	@Override
	public String toString() {
		return "NewBoardVo [board_id=" + board_id + ", board_title="
				+ board_title + ", board_use=" + board_use + ", board_dt="
				+ board_dt + ", std_id=" + std_id + "]";
	}
	
	
	
}
