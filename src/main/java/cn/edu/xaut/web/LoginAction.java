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
		
		
		System.out.println("ҳ����Ϣ��"+page);
		System.out.println("��¼��Ϣ:"+user.getUsername()+"\n"+user.getPassword());
		if(user.getUsername().equals("admin")&&user.getPassword().equals("password")) {
			
			books = loginService.findBookByPage(page, pageSize);
			
			this.totalPage = loginService.findTotalPage(pageSize);
			
			// ����Ա����
			return "admin";
		}
		
		// �û���֤
		HttpSession session = ServletActionContext.getRequest().getSession();
		User duser = new User();  
		if(session.getAttribute("User")!=null) {
			//ΪBacktoUser�ṩ����
			duser = (User) session.getAttribute("User");
		}else {
		//���ݿ��û���Ϣ
			duser = loginService.findUserByUsername(user.getUsername());
		}	
		if(user.getUsername().equals(duser.getUsername()) && user.getPassword().equals(duser.getPassword())){
			
			ubls = loginService.findLendById(duser.getId());
//			UBL ubl1 = new UBL(1,"����1",101,"2020��6��19��");
			
			session.setAttribute("User", duser);
			return "user";
		}else {
			// ��֤ʧ��
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
