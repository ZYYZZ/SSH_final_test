package cn.edu.xaut.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.xaut.dao.*;

@Service("UserServiceImp")
public class UserServiceImp implements UserService {
	
	@Resource(name="UserDaoImp")
	UserDao userDao;
	
	@Resource(name="UBRDaoImp")
	UBRDao ubrDao;
	
	@Resource(name="UBLDaoImp")
	UBLDao ublDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UBRDao getUbrDao() {
		return ubrDao;
	}

	public void setUbrDao(UBRDao ubrDao) {
		this.ubrDao = ubrDao;
	}

	public UBLDao getUblDao() {
		return ublDao;
	}

	public void setUblDao(UBLDao ublDao) {
		this.ublDao = ublDao;
	}

	public void rebook(int uid, int bid) {
		// TODO Auto-generated method stub
		ubrDao.Rbook(uid, bid);
		ublDao.rebook(uid, bid);
	}

	public void passwordupdate(int uid, String npass) {
		// TODO Auto-generated method stub
		userDao.PasswordUpdate(npass, uid);
	}

}
