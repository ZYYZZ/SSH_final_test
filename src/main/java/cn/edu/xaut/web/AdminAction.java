package cn.edu.xaut.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.xaut.entity.*;
import cn.edu.xaut.service.*;

@Controller
@Scope("prototype")
public class AdminAction extends ActionSupport{
	
	private List<User> users;
	private List<UBL> ubls;
	private List<UBR> ubrs;
	
	private Book book;

	private int bid;
	
	@Resource(name="AdminServiceImp")
	private AdminService adminService;
	
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
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
		users = adminService.userprint();

		return SUCCESS;
	}
	
	public String ublprint() {
		
//		Date d = new Date();
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		UBL ubl1 = new UBL(1,"数据结构","wang",df.format(d));
		ubls = adminService.ublprint();
		return SUCCESS;
	}
	
	public String bookdel() {
		//数据库删书
		adminService.bookdel(bid);
		return SUCCESS;
	}
	
	public String bookupd() {
		System.out.println("修改id一跳："+bid);
		return SUCCESS;
	}
	
	public String addbook() {
		//填书跳转
		return SUCCESS;
	}
	
	public String rebprint() {
		ubrs = adminService.rebprint();
		return SUCCESS;
	}
	
	public String addinfo() {
		//调用DAO持久化书本信息
		adminService.addBook(book);
		return SUCCESS;
	}
	
	public String bupdateinfo() {
		System.out.println("修改id二跳："+book.getId());
		//调用DAO修改书本信息
		adminService.bupdateinfo(book);
		return SUCCESS;
	}
	
}
