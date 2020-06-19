package cn.edu.xaut.web;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.xaut.entity.User;

public class UserAction extends ActionSupport{
	private int uid;
	private int bid;
	
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	
	public String rebook() {
		//数据库删借书记录
		System.out.println("rebook:"+this.bid+this.uid);
		return SUCCESS;
	}
	
	public String passwordupdate() {
		//修改数据库密码
		System.out.println("修改信息："+user);
		return SUCCESS;
	}
	
}
