package cn.edu.xaut.web;

import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.xaut.entity.User;
import cn.edu.xaut.service.UserService;
import cn.edu.xaut.service.UserServiceImp;

public class UserAction extends ActionSupport{
	private int uid;
	private int bid;
	private String npassword;
	
	public String getNpassword() {
		return npassword;
	}
	public void setNpassword(String npassword) {
		this.npassword = npassword;
	}

	private User user;
	
	private UserService userService = new UserServiceImp();
	
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
		userService.rebook(uid, bid);
		System.out.println("rebook:"+this.bid+this.uid);
		return SUCCESS;
	}
	
	public String passwordupdate() {
		//修改数据库密码
		userService.passwordupdate(uid, npassword);
		System.out.println("修改信息："+npassword);
		return SUCCESS;
	}
	
}
