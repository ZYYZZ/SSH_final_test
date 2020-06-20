package cn.edu.xaut.entity;

import java.io.Serializable;

public class User implements Serializable{
	
	private Integer id;
	private String username;
	private String password;
	private String email;
	private String phonenum;
	
	public User(int id,String username,String email,String phonenum) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.phonenum = phonenum;
	}
	
	public User(String username,String email,String phonenum,String password) {
		this.username = username;
		this.email = email;
		this.phonenum = phonenum;
		this.password = password;
	}
	
	public User() {
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String name) {
		this.username = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	

}
