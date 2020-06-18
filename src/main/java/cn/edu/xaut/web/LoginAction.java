package cn.edu.xaut.web;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.xaut.entity.Book;
import cn.edu.xaut.entity.User;

public class LoginAction extends ActionSupport{
	
	private List<Book> books;
	private User user;
	
	private int page;
	private int pageSize;
	private int totalPage;
	
	
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
		Book book1 = new Book(1,"数据结构",32.5f,20,"王涵");
		Book book2 = new Book(2,"编译原理",20.5f,10,"赵雪");
		Book book3 = new Book(3,"计算机网络",31.5f,12,"墨菲菲");
		Book book4 = new Book(4,"机组原理",61.5f,22,"韩忠国");
		
		books = new ArrayList<Book>();
		this.books.add(book1);
		this.books.add(book2);
		this.books.add(book3);
		this.books.add(book4);
		
		this.totalPage = 2;
		System.out.println(page);
		System.out.println("登录信息:"+user.getUsername()+"\n"+user.getPassword());
		if(user.getUsername().equals("admin")&&user.getPassword().equals("password")) {
			// 管理员界面
			return "admin";
		}
		if(user.getUsername().equals("admin")){		
			// 用户验证
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
	
	
}
