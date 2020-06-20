package cn.edu.xaut.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.xaut.entity.*;


public class LoginAction extends ActionSupport{
	
	private List<Book> books;
	private User user;
	private List<UBL> ubls;
	
	private int page;
	private int pageSize;
	private int totalPage;
	
	
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
			
			Book book1 = new Book(1,"数据结构",32.5f,20,"王涵");
			Book book2 = new Book(2,"编译原理",20.5f,10,"赵雪");
			Book book3 = new Book(3,"计算机网络",31.5f,12,"墨菲菲");
			Book book4 = new Book(4,"机组原理",61.5f,22,"韩忠国");
			books = new ArrayList<Book>();
			
			this.totalPage = 2;
			
			this.books.add(book1);
			this.books.add(book2);
			this.books.add(book3);
			this.books.add(book4);
			
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
		duser.setUsername("asd123");
		duser.setPassword("123");
		duser.setEmail("260@qq.com");
		duser.setId(1);
		duser.setPhonenum("15389");
		}	
		if(user.getUsername().equals(duser.getUsername()) && user.getPassword().equals(duser.getPassword())){
			
			ubls = new ArrayList<UBL>();
			UBL ubl1 = new UBL(1,"书名1",101,"2020年6月19日");
			UBL ubl2 = new UBL(2,"书名2",102,"2020年6月18日");
			
			ubls.add(ubl1);		ubls.add(ubl2);
			
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
