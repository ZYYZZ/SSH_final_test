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
		//���ݿ�ɾ�����¼
		System.out.println("rebook:"+this.bid+this.uid);
		return SUCCESS;
	}
	
	public String passwordupdate() {
		//�޸����ݿ�����
		System.out.println("�޸���Ϣ��"+user);
		return SUCCESS;
	}
	
}
