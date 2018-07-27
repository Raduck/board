package kr.or.ddit.studentUser.model;

import java.util.Date;

public class StudentUserVo{

	private int id; // 학생번호
	private String std_id; //학생 아이디
	private String pass; //학생 비밀번호
	private String name; // 학생이름
	private int call_cnt; // 호출횟수
	private Date reg_dt;
	private String addr1;
	private String addr2;
	private String zipcd;
	private String pic;
	private String picpath;
	private String picname;

	
	
	public StudentUserVo() {
		
	}
	
	public boolean validData(String std_id, String pass) {
		if (this.getStd_id().equals(std_id)
				&& this.getPass().equals(pass)) {
			return true;
		}else{
			return false;
		}
		
	}
	
	
	public String getStd_id() {
		return std_id;
	}
	
	
	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}
	
	
	public String getPass() {
		return pass;
	}
	
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	public String getPicname() {
		return picname;
	}

	public void setPicname(String picname) {
		this.picname = picname;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getZipcd() {
		return zipcd;
	}

	public void setZipcd(String zipcd) {
		this.zipcd = zipcd;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getPicpath() {
		return picpath;
	}

	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}


	public Date getReg_dt() {
		return reg_dt;
	}

	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCall_cnt() {
		return call_cnt;
	}

	public void setCall_cnt(int call_cnt) {
		this.call_cnt = call_cnt;
	}

	@Override
	public String toString() {
		return "StudentVo [id=" + id + ", name=" + name + ", call_cnt="
				+ call_cnt + "]";
	}

}
