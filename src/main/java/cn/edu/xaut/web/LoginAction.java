package cn.edu.xaut.web;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.xaut.entity.Book;
import cn.edu.xaut.entity.User;

public class LoginAction extends ActionSupport{
	
	List<Book> books;
	User user;
	
	int page;
	int pageSize;
	int totalPage;
	
	
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
//	insert into Book values('�㷨���', 41 , 36.5 ,'��ѩ');
//	insert into Book values('����ԭ��', 10 , 20.5 ,'ī�Ʒ�');
//	insert into Book values('���������', 12 , 31.5 ,'���ҹ�');
//	insert into Book values('����ԭ��', 22 , 61.5 ,'����Ӣ');
//	insert into Book values('JSP���',18,39.5,'������')

	public String execute() {
		Book book1 = new Book(1,"���ݽṹ",(float)32.5,20,"����");
		Book book2 = new Book(2,"����ԭ��",(float)20.5,10,"��ѩ");
		Book book3 = new Book(3,"���������",(float)31.5,12,"ī�Ʒ�");
		Book book4 = new Book(1,"����ԭ��",(float)61.5,22,"���ҹ�");
		
		books = new ArrayList();
		this.books.add(book1);
		this.books.add(book2);
		this.books.add(book3);
		this.books.add(book4);
		this.totalPage = 2;
		
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
	
	
}
