package cn.edu.xaut.dao;

import java.util.List;

import cn.edu.xaut.entity.UBR;

public interface UBRDao {
	public void Rbook(int Uid,int Bid);
	public List<UBR> findAll();
}
