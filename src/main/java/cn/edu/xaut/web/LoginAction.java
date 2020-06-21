package cn.edu.xaut.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.xaut.entity.*;
import cn.edu.xaut.service.*;

@Controller
@Scope("prototype")
public class LoginAction extends ActionSupport{
	
	private List<Book> books;
	private User user;
	private List<UBL> ubls;
	
	private int page;
	private int pageSize;
	private int totalPage;
	
	@Resource(name="LoginServiceImp")
	private LoginService loginService;
	
	
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
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		// �û���֤
		if(session.getAttribute("User")!=null) {
			//ΪBacktoUser�ṩ����
			user = (User) session.getAttribute("User");
			ubls = loginService.findLendById(user.getId());
			
			return "user";
		}else {
		//���ݿ��û���Ϣ
			
			if(user.getUsername().equals("admin")&&user.getPassword().equals("password")) {
				
				books = loginService.findBookByPage(page, pageSize);
				
				this.totalPage = loginService.findTotalPage(pageSize);
				
				// ����Ա����
				return "admin";
			}
			
			if(loginService.findUserByUsername(user.getUsername()).getPassword().equals(user.getPassword())){
				ubls = loginService.findLendById(loginService.findUserByUsername(user.getUsername()).getId());
				
				session.setAttribute("User", loginService.findUserByUsername(user.getUsername()));
				return "user";
			}else {
				// ��֤ʧ��
				return INPUT;
			}
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
	
	public String quit() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.invalidate();
		return SUCCESS;
	}
	
}
