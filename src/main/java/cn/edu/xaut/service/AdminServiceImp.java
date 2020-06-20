package cn.edu.xaut.service;

import java.util.List;

import cn.edu.xaut.entity.*;
import cn.edu.xaut.dao.*;

public class AdminServiceImp implements AdminService {

	public List<User> userprint() {
		// TODO Auto-generated method stub
		UserDao udao = new UserDaoImp();
		return udao.findAll();
	}

	public List<UBL> ublprint() {
		// TODO Auto-generated method stub
		UBLDao ldao = new UBLDaoImp();
		return ldao.findAll();
	}

	public void bookdel(int bid) {
		// TODO Auto-generated method stub
		BookDao bdao = new BookDaoImp();
		bdao.delete(bid);
	}

	public List<UBR> rebprint() {
		// TODO Auto-generated method stub
		UBRDao rdao = new UBRDaoImp();
		return rdao.findAll();
	}

	public void addBook(Book nbook) {
		// TODO Auto-generated method stub
		BookDao bdao = new BookDaoImp();
		bdao.addbook(nbook);
	}

	public void bupdateinfo(Book ubook) {
		// TODO Auto-generated method stub
		BookDao bdao = new BookDaoImp();
		bdao.update(ubook);
	}

}
