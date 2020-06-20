package DaoTest;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import cn.edu.xaut.dao.BookDao;
import cn.edu.xaut.dao.BookDaoImp;
import cn.edu.xaut.dao.UserDao;
import cn.edu.xaut.dao.UserDaoImp;
import cn.edu.xaut.entity.UBL;
import cn.edu.xaut.utils.HibernateUtils;

public class UBLDaoT {
	
	@Test
	public void findAll() {
		Session session = HibernateUtils.getSession();
		String hql = "from UBL";
		Query query = session.createQuery(hql);
		List<UBL> list = query.list();
		for (UBL ubl : list) {
			System.out.println(ubl);
		}
	}
	
	@Test
	public void delete() {
		Session session = HibernateUtils.getSession();
		String hql = "delete from UBL where bid = 105 and uid = 100";
		Query q = session.createQuery(hql);
		q.executeUpdate();
		session.beginTransaction().commit();
		session.close();
	}
	
	@Test
	public void insert() {
		Session session = HibernateUtils.getSession();
		UBL ubl = new UBL();
		BookDao bdao = new BookDaoImp();
		UserDao udao = new UserDaoImp();
		ubl.setBid(104);	ubl.setUid(108);
		ubl.setBname("bname");
		ubl.setUname("uname");
		ubl.setLtime(String.valueOf(System.currentTimeMillis()));
		session.save(ubl);
		session.beginTransaction().commit();
		session.close();
	}
	
	@Test
	public void ltime() {
		Session session = HibernateUtils.getSession();
		String hql = "select Ltime from UBL where bid = ? and uid = ?";
		Query q = session.createQuery(hql);
		q.setInteger(0, 105);	q.setInteger(1, 100);
		System.out.println(q.list().get(0));
	}
	
	@Test
	public void findid() {
		Session session = HibernateUtils.getSession();
		String hql = "from UBL where uid = ?";
		Query q = session.createQuery(hql);
		q.setInteger(0, 100);
		List<UBL> list = q.list();
		for (UBL ubl : list) {
			System.out.println(ubl);
		}
	}
}
