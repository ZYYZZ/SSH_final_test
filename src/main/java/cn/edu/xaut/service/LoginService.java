package cn.edu.xaut.service;

import java.util.List;

import cn.edu.xaut.entity.*;

public interface LoginService {
	public List<Book> findBookByPage(int page,int pagesize);
	public int findTotalPage(int pagesize);
	public User findUserByUsername(String username);
	public void addUser(String username, String email, String password, String phonenum);
	public List<UBL> findLendById(int uid);
}
