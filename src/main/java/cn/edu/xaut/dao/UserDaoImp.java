package cn.edu.xaut.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import cn.edu.xaut.entity.Book;
import cn.edu.xaut.entity.UBL;
import cn.edu.xaut.entity.User;
import cn.edu.xaut.utils.HibernateUtils;

@Repository("UserDaoImp")
public class UserDaoImp implements UserDao {
	
	@Resource(name = "sessionFactory")
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String hql = "from User";
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		return list;
	}

	public User seachone(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String hql = "from User where id=?";
		Query q = session.createQuery(hql);
		q.setInteger(0, id);
		return ( (User) q.list().get(0) );
	}

	public User seachone(String username) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String hql = "from User where username=?";
		Query q = session.createQuery(hql);
		q.setString(0, username);
		return ( (User) q.list().get(0) );
	}

	public void addUser(String username, String email, String password, String phonenum) {
		// TODO Auto-generated method stub
		User user = new User(username,email,phonenum,password);
		Session session = sessionFactory.openSession();
		session.save(user);
		session.beginTransaction().commit();
		session.close();
	}

	public void PasswordUpdate(String newpassword, int uid) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String hql = "update User u set u.password = ? where u.id =?";
		Query q = session.createQuery(hql);
		q.setString(0, newpassword);	q.setInteger(1, uid);
		q.executeUpdate();
		session.beginTransaction().commit();
		session.close();
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String hql = "delete from User where id = ?";
		Query q = session.createQuery(hql);
		q.setInteger(0, id);
		q.executeUpdate();
		session.beginTransaction().commit();
		session.close();
	}

}
