package DaoTest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import cn.edu.xaut.utils.HibernateUtils;

public class UserDaoT {
	
	@Test
	public void update() {
		Session session = HibernateUtils.getSession();
		String hql = "update User u set u.password = ? where u.id =?";
		Query q = session.createQuery(hql);
		q.setString(0, "123");	q.setInteger(1, 100);
		q.executeUpdate();
		session.beginTransaction().commit();
		session.close();
	}
	
	@Test
	public void delete() {
		Session session = HibernateUtils.getSession();
		String hql = "delete from User where id = ?";
		Query q = session.createQuery(hql);
		q.setInteger(0, 103);
		q.executeUpdate();
		session.beginTransaction().commit();
		session.close();
	}
}
