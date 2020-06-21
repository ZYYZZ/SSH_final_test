package cn.edu.xaut.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import cn.edu.xaut.entity.UBL;

@Repository("UBLDaoImp")
public class UBLDaoImp implements UBLDao {
	
	@Resource(name = "sessionFactory")
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<UBL> findAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String hql = "from UBL";
		Query query = session.createQuery(hql);
		List<UBL> list = query.list();
		return list;
	}

	public void rebook(int uid, int bid) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String hql = "delete from UBL where bid = ? and uid = ?";
		Query q = session.createQuery(hql);
		q.setInteger(0, bid);	q.setInteger(1, uid);
		q.executeUpdate();
		session.beginTransaction().commit();
		session.close();
	}

	public void lendbook(int uid, int bid) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		UBL ubl = new UBL();
		BookDao bdao = new BookDaoImp();
		UserDao udao = new UserDaoImp();
		ubl.setBid(bid);	ubl.setUid(uid);
		ubl.setBname(bdao.seachone(bid).getName());
		ubl.setUname(udao.seachone(uid).getUsername());
		ubl.setLtime(String.valueOf(System.currentTimeMillis()));
		session.save(ubl);
		session.beginTransaction().commit();
		session.close();
	}

	public String lendtime(int uid, int bid) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String hql = "select Ltime from UBL where bid = ? and uid = ?";
		Query q = session.createQuery(hql);
		q.setInteger(0, bid);	q.setInteger(1, uid);
		
		return ( (String)q.list().get(0) );
	}

	public List<UBL> findByUid(int uid) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String hql = "from UBL where uid = ?";
		Query q = session.createQuery(hql);
		q.setInteger(0, uid);
		List<UBL> list = q.list();
		return list;
	}

}
