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
		Book book1 = new Book(1,"���ݽṹ",32.5f,20,"����");
		Book book2 = new Book(2,"����ԭ��",20.5f,10,"��ѩ");
		Book book3 = new Book(3,"���������",31.5f,12,"ī�Ʒ�");
		Book book4 = new Book(4,"����ԭ��",61.5f,22,"���ҹ�");
		
		books = new ArrayList<Book>();
		this.books.add(book1);
		this.books.add(book2);
		this.books.add(book3);
		this.books.add(book4);
		
		this.totalPage = 2;
		System.out.println(page);
		System.out.println("��¼��Ϣ:"+user.getUsername()+"\n"+user.getPassword());
		if(user.getUsername().equals("admin")&&user.getPassword().equals("password")) {
			// ����Ա����
			return "admin";
		}
		if(user.getUsername().equals("admin")){		
			// �û���֤
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
	
	
}
