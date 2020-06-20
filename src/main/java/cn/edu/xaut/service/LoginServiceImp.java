package cn.edu.xaut.service;

import java.util.List;

import cn.edu.xaut.entity.*;
import cn.edu.xaut.dao.*;

public class LoginServiceImp implements LoginService {

	public List<Book> findBookByPage(int page, int pagesize) {
		// TODO Auto-generated method stub
		BookDao bdao = new BookDaoImp();
		List<Book> list = bdao.findBookByPage(page, pagesize);
		return list;
	}

	public int findTotalPage(int pagesize) {
		// TODO Auto-generated method stub
		BookDao bdao = new BookDaoImp();
		return bdao.findBookTotalPage(pagesize);
	}

	public User findUserByUsername(String username) {
		// TODO Auto-generated method stub
		User user = new User();
		UserDao udao = new UserDaoImp();
		user = udao.seachone(username);
		return user;
	}

	public void addUser(String username, String email, String password, String phonenum) {
		// TODO Auto-generated method stub
		UserDao udao = new UserDaoImp();
		udao.addUser(username, email, password, phonenum);
	}

	public List<UBL> findLendById(int uid) {
		// TODO Auto-generated method stub
		UBLDao ldao = new UBLDaoImp();
		return ldao.findByUid(uid);
	}

}
