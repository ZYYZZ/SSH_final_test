package cn.edu.xaut.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.xaut.entity.*;

public class AdminAction extends ActionSupport{
	
	private List<User> users;
	private List<UBL> ubls;
	private List<UBR> ubrs;
	
	private int bid;
	
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public List<UBR> getUbrs() {
		return ubrs;
	}
	public void setUbrs(List<UBR> ubrs) {
		this.ubrs = ubrs;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}

	private String result;
	private List<Book> books;
	private int totalPage;
	private int page;
	private int pageSize;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
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
	public List<UBL> getUbls() {
		return ubls;
	}
	public void setUbls(List<UBL> ubls) {
		this.ubls = ubls;
	}
	

	public String userprint() {
		User user1 = new User(100,"asd123","2609728289@qq.com","15389218283");
		User user2 = new User(101,"asd1234","2609728289@qq.com","15389218283");
		User user3 = new User(102,"asd1235","123@qq.com","15389218283");
		
		users = new ArrayList<User>();
		
		users.add(user1);
		users.add(user2);
		users.add(user3);
		return SUCCESS;
	}
	
	public String ublprint() {
		
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		UBL ubl1 = new UBL(1,"���ݽṹ","wang",df.format(d));
		UBL ubl2 = new UBL(2,"���㷽��","wang",df.format(d));
		
		ubls = new ArrayList<UBL>();
		ubls.add(ubl1);
		ubls.add(ubl2);
		return SUCCESS;
	}
	
	public String bookdel() {
		return SUCCESS;
	}
	
	public String bookupd() {
		System.out.println("�޸�idһ����"+bid);
		return SUCCESS;
	}
	
	public String addbook() {
		return SUCCESS;
	}
	
	public String rebprint() {
		UBR ubr1 = new UBR(1,"���ݽṹ","wang",1);
		UBR ubr2 = new UBR(1,"���ݽṹ","wang",0);
		
		ubrs = new ArrayList<UBR>();
		ubrs.add(ubr1);
		ubrs.add(ubr2);
		return SUCCESS;
	}
	
	public String addtodata() {
		//����DAO�־û��鱾��Ϣ
		return SUCCESS;
	}
	
	public String bupdateinfo() {
		System.out.println("�޸�id������"+bid);
		//����DAO�޸��鱾��Ϣ
		return SUCCESS;
	}
	
}
