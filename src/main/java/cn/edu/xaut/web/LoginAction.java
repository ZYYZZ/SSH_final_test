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
		
		
		System.out.println("ҳ����Ϣ��"+page);
		System.out.println("��¼��Ϣ:"+user.getUsername()+"\n"+user.getPassword());
		if(user.getUsername().equals("admin")&&user.getPassword().equals("password")) {
			
			Book book1 = new Book(1,"���ݽṹ",32.5f,20,"����");
			Book book2 = new Book(2,"����ԭ��",20.5f,10,"��ѩ");
			Book book3 = new Book(3,"���������",31.5f,12,"ī�Ʒ�");
			Book book4 = new Book(4,"����ԭ��",61.5f,22,"���ҹ�");
			books = new ArrayList<Book>();
			
			this.totalPage = 2;
			
			this.books.add(book1);
			this.books.add(book2);
			this.books.add(book3);
			this.books.add(book4);
			
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
		duser.setUsername("asd123");
		duser.setPassword("123");
		duser.setEmail("260@qq.com");
		duser.setId(1);
		duser.setPhonenum("15389");
		}	
		if(user.getUsername().equals(duser.getUsername()) && user.getPassword().equals(duser.getPassword())){
			
			ubls = new ArrayList<UBL>();
			UBL ubl1 = new UBL(1,"����1",101,"2020��6��19��");
			UBL ubl2 = new UBL(2,"����2",102,"2020��6��18��");
			
			ubls.add(ubl1);		ubls.add(ubl2);
			
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
