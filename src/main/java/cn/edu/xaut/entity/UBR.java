package cn.edu.xaut.entity;

public class UBR {
	
	private Integer bid;
	private String bname;
	private String uname;
	private int type;
	
	public UBR(int bid,String bname,String uname,int Ltime) {
		this.bid = bid;
		this.bname = bname;
		this.uname = uname;
		this.type = Ltime;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	
}
