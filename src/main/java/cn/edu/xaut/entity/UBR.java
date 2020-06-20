package cn.edu.xaut.entity;

import java.io.Serializable;

public class UBR implements Serializable{
	
	private Integer rid;	
	private Integer bid;
	private String bname;
	private String uname;
	private String Rtime;
	private int type;
	

	public UBR(int bid,String bname,String uname,int type) {
		this.bid = bid;
		this.bname = bname;
		this.uname = uname;
		this.type = type;
	}
	
	public UBR() {
		
	}

	
	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getRtime() {
		return Rtime;
	}

	public void setRtime(String rtime) {
		Rtime = rtime;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}
