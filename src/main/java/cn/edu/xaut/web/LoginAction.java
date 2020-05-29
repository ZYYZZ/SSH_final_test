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
//	insert into Book values('算法设计', 41 , 36.5 ,'赵雪');
//	insert into Book values('编译原理', 10 , 20.5 ,'墨菲菲');
//	insert into Book values('计算机网络', 12 , 31.5 ,'韩忠国');
//	insert into Book values('机组原理', 22 , 61.5 ,'白中英');
//	insert into Book values('JSP设计',18,39.5,'耿祥义')

	public String execute() {
		Book book1 = new Book(1,"数据结构",(float)32.5,20,"王涵");
		Book book2 = new Book(2,"编译原理",(float)20.5,10,"赵雪");
		Book book3 = new Book(3,"计算机网络",(float)31.5,12,"墨菲菲");
		Book book4 = new Book(1,"机组原理",(float)61.5,22,"韩忠国");
		
		books = new ArrayList();
		this.books.add(book1);
		this.books.add(book2);
		this.books.add(book3);
		this.books.add(book4);
		this.totalPage = 2;
		
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
	
	
}
