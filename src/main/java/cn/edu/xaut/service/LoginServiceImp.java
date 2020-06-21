package cn.edu.xaut.service;

import java.util.List;

import javax.annotation.*;

import org.springframework.stereotype.Service;

import cn.edu.xaut.entity.*;
import cn.edu.xaut.dao.*;

@Service("LoginServiceImp")
public class LoginServiceImp implements LoginService {
	
	@Resource(name="BookDaoImp")
	BookDao bookDao;
	
	@Resource(name="UserDaoImp")
	UserDao userDao;
	
	@Resource(name="UBLDaoImp")
	UBLDao ublDao;
	
	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UBLDao getUblDao() {
		return ublDao;
	}

	public void setUblDao(UBLDao ublDao) {
		this.ublDao = ublDao;
	}

	public List<Book> findBookByPage(int page, int pagesize) {
		// TODO Auto-generated method stub
		List<Book> list = bookDao.findBookByPage(page, pagesize);
		return list;
	}

	public int findTotalPage(int pagesize) {
		// TODO Auto-generated method stub
		return bookDao.findBookTotalPage(pagesize);
	}

	public User findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.seachone(username);
	}

	public void addUser(String username, String email, String password, String phonenum) {
		// TODO Auto-generated method stub
		userDao.addUser(username, email, password, phonenum);
	}

	public List<UBL> findLendById(int uid) {
		// TODO Auto-generated method stub
		return ublDao.findByUid(uid);
	}

}
