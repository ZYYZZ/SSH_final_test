package cn.edu.xaut.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.xaut.entity.*;
import cn.edu.xaut.dao.*;

@Service("AdminServiceImp")
public class AdminServiceImp implements AdminService {
	
	@Resource(name="BookDaoImp")
	BookDao bookDao;
	
	@Resource(name="UserDaoImp")
	UserDao userDao;
	
	@Resource(name="UBLDaoImp")
	UBLDao ublDao;
	
	@Resource(name="UBRDaoImp")
	UBRDao ubrDao;

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

	public UBRDao getUbrDao() {
		return ubrDao;
	}

	public void setUbrDao(UBRDao ubrDao) {
		this.ubrDao = ubrDao;
	}

	public List<User> userprint() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	public List<UBL> ublprint() {
		// TODO Auto-generated method stub
		return ublDao.findAll();
	}

	public void bookdel(int bid) {
		// TODO Auto-generated method stub
		bookDao.delete(bid);
	}

	public List<UBR> rebprint() {
		// TODO Auto-generated method stub
		return ubrDao.findAll();
	}

	public void addBook(Book nbook) {
		// TODO Auto-generated method stub
		bookDao.addbook(nbook);
	}

	public void bupdateinfo(Book ubook) {
		// TODO Auto-generated method stub
		bookDao.update(ubook);
	}

}
