package cn.edu.xaut.entity;

import java.io.Serializable;

public class UBL implements Serializable{
	Integer lid;
	Integer bid;
	Integer uid;
	String bname;
	String uname;
	String Ltime;
	
	
	@Override
	public String toString() {
		return "UBL [bid=" + bid + ", uid=" + uid + ", bname=" + bname + ", uname=" + uname + ", Ltime=" + Ltime + "]";
	}
	public UBL() {
		
	}
	
	public UBL(int bid,String bname,String uname,String Ltime) {
		this.bid = bid;
		this.bname = bname;
		this.uname = uname;
		this.Ltime = Ltime;
	}
	
	public UBL(int bid,String bname,int uid,String Ltime) {
		this.bid = bid;
		this.uid = uid;
		this.bname = bname;
		this.Ltime = Ltime;
	}
	
	
	
	public Integer getLid() {
		return lid;
	}
	public void setLid(Integer lid) {
		this.lid = lid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
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
	public String getLtime() {
		return Ltime;
	}
	public void setLtime(String ltime) {
		Ltime = ltime;
	}
	
	
}
