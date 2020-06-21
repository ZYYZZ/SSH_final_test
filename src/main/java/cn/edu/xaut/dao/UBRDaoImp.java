package cn.edu.xaut.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import cn.edu.xaut.entity.UBR;
import cn.edu.xaut.utils.HibernateUtils;

public class UBRDaoImp implements UBRDao {

	public void Rbook(int uid, int bid) {
		// TODO Auto-generated method stub
		long limit = 2592000000l;
		int type = 1;
		UBLDao ldao = new UBLDaoImp();
		if(Long.valueOf(ldao.lendtime(uid, bid))-(System.currentTimeMillis())>limit){
			type = 0;
		}
		Session session = HibernateUtils.getSession();
		UBR ubr = new UBR();
		BookDao bdao = new BookDaoImp();
		UserDao udao = new UserDaoImp();
		ubr.setBid(bid);	ubr.setType(type);
		ubr.setBname(bdao.seachone(bid).getName());
		ubr.setUname(udao.seachone(uid).getUsername());
		ubr.setRtime(String.valueOf(System.currentTimeMillis()));
		session.save(ubr);
		session.beginTransaction().commit();
		session.close();

	}

	public List<UBR> findAll() {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSession();
		String hql = "from UBR";
		Query q = session.createQuery(hql);
		List<UBR> list = q.list();
		return list;
	}

}
