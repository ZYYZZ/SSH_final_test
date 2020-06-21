package cn.edu.xaut.web;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.xaut.entity.User;
import cn.edu.xaut.service.UserService;

@Controller
@Scope("prototype")
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
	
	@Resource(name="UserServiceImp")
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
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
		return SUCCESS;
	}
	
	public String passwordupdate() {
		//修改数据库密码
		userService.passwordupdate(uid, npassword);
		return SUCCESS;
	}
	
}
