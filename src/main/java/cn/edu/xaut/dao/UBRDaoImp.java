package cn.edu.xaut.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import cn.edu.xaut.entity.UBR;

@Repository("UBRDaoImp")
public class UBRDaoImp implements UBRDao {
	
	@Resource(name = "sessionFactory")
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void Rbook(int uid, int bid) {
		// TODO Auto-generated method stub
		long limit = 2592000000l;
		int type = 1;
		UBLDao ldao = new UBLDaoImp();
		if(Long.valueOf(ldao.lendtime(uid, bid))-(System.currentTimeMillis())>limit){
			type = 0;
		}
		Session session = sessionFactory.openSession();
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
		Session session = sessionFactory.openSession();
		String hql = "from UBR";
		Query q = session.createQuery(hql);
		List<UBR> list = q.list();
		return list;
	}

}
