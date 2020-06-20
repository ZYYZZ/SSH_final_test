package cn.edu.xaut.service;

import cn.edu.xaut.dao.*;

public class UserServiceImp implements UserService {

	public void rebook(int uid, int bid) {
		// TODO Auto-generated method stub
		UBRDao rdao = new UBRDaoImp();
		rdao.Rbook(uid, bid);
	}

	public void passwordupdate(int uid, String npass) {
		// TODO Auto-generated method stub
		UserDao udao = new UserDaoImp();
		udao.PasswordUpdate(npass, uid);
	}

}
