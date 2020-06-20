package cn.edu.xaut.dao;

import java.util.List;

import cn.edu.xaut.entity.User;

public interface UserDao {
	public List<User> findAll();
	public User seachone(int id);
	public User seachone(String username);
	public void addUser(String username, String email,String password, String phonenum);
	public void PasswordUpdate(String newpassword,int uid);
	public void delete(int id);
}
