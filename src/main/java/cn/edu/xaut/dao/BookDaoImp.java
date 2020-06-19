package cn.edu.xaut.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import cn.edu.xaut.entity.Book;
import cn.edu.xaut.utils.HibernateUtils;

public class BookDaoImp implements BookDao {

	public List<Book> findBookByPage(int page, int pageSize) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSession();
		String hql = "from Customer";
		Query query = session.createQuery(hql);
		query.setFirstResult((page-1)*pageSize);
		query.setMaxResults(pageSize);
		
		List<Book> customers = query.list();
		session.close();
		return customers;
	}

	public void delete(int bid) {
		// TODO Auto-generated method stub

	}

	public void update(Book cbook) {
		// TODO Auto-generated method stub

	}

	public void addbook(Book nbook) {
		// TODO Auto-generated method stub

	}

	public int findBookTotalPage(int pageSize) {
		// TODO Auto-generated method stub
		return 0;
	}

}
