package cn.edu.xaut.service;

import java.util.List;

import cn.edu.xaut.entity.*;

public interface AdminService {
	public List<User> userprint();
	public List<UBL> ublprint();
	public void bookdel(int bid);
	public List<UBR> rebprint();
	public void addBook(Book nbook);
	public void bupdateinfo(Book ubook);
}
