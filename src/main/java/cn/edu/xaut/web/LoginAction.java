package cn.edu.xaut.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.xaut.entity.*;
import cn.edu.xaut.service.*;


public class LoginAction extends ActionSupport{
	
	private List<Book> books;
	private User user;
	private List<UBL> ubls;
	
	private int page;
	private int pageSize;
	private int totalPage;
	
	private LoginService loginService = new LoginServiceImp();
	
	
	public List<UBL> getUbls() {
		return ubls;
	}
	public void setUbls(List<UBL> ubls) {
		this.ubls = ubls;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public String login() {
		
		
		System.out.println("页码信息："+page);
		System.out.println("登录信息:"+user.getUsername()+"\n"+user.getPassword());
		if(user.getUsername().equals("admin")&&user.getPassword().equals("password")) {
			
			books = loginService.findBookByPage(page, pageSize);
			
			this.totalPage = loginService.findTotalPage(pageSize);
			
			// 管理员界面
			return "admin";
		}
		
		// 用户验证
		HttpSession session = ServletActionContext.getRequest().getSession();
		User duser = new User();  
		if(session.getAttribute("User")!=null) {
			//为BacktoUser提供服务
			duser = (User) session.getAttribute("User");
		}else {
		//数据库用户信息
			duser = loginService.findUserByUsername(user.getUsername());
		}	
		if(user.getUsername().equals(duser.getUsername()) && user.getPassword().equals(duser.getPassword())){
			
			ubls = loginService.findLendById(duser.getId());
//			UBL ubl1 = new UBL(1,"书名1",101,"2020年6月19日");
			
			session.setAttribute("User", duser);
			return "user";
		}else {
			// 验证失败
			return INPUT;
		}
	}
	
	public String backtoadmin() {
		System.out.println("backtoadmin//comed!");
		return SUCCESS;
	}

public String backtouser() {
		System.out.println("backtouser//comed!");
		return SUCCESS;
	}
	
}
