package cn.edu.xaut.dao;

import java.util.List;

import cn.edu.xaut.entity.UBL;

public interface UBLDao {
	public List<UBL> findAll();
	public void rebook(int uid,int bid);
	public void lendbook(int uid,int bid);
	public String lendtime(int uid,int bid);
	public List<UBL> findByUid(int uid);
}
