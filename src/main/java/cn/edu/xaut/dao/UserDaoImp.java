package cn.edu.xaut.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import cn.edu.xaut.entity.Book;
import cn.edu.xaut.entity.UBL;
import cn.edu.xaut.entity.User;
import cn.edu.xaut.utils.HibernateUtils;

public class UserDaoImp implements UserDao {

	public List<User> findAll() {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSession();
		String hql = "from User";
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		return list;
	}

	public User seachone(int id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSession();
		String hql = "from User where id=?";
		Query q = session.createQuery(hql);
		q.setInteger(0, id);
		return ( (User) q.list().get(0) );
	}

	public User seachone(String username) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSession();
		String hql = "from User where username=?";
		Query q = session.createQuery(hql);
		q.setString(0, username);
		return ( (User) q.list().get(0) );
	}

	public void addUser(String username, String email, String password, String phonenum) {
		// TODO Auto-generated method stub
		User user = new User(username,email,phonenum,password);
		Session session = HibernateUtils.getSession();
		session.save(user);
		session.beginTransaction().commit();
		session.close();
	}

	public void PasswordUpdate(String newpassword, int uid) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSession();
		String hql = "update User u set u.password = ? where u.id =?";
		Query q = session.createQuery(hql);
		q.setString(0, newpassword);	q.setInteger(1, uid);
		q.executeUpdate();
		session.beginTransaction().commit();
		session.close();
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSession();
		String hql = "delete from User where id = ?";
		Query q = session.createQuery(hql);
		q.setInteger(0, id);
		q.executeUpdate();
		session.beginTransaction().commit();
		session.close();
	}

}
