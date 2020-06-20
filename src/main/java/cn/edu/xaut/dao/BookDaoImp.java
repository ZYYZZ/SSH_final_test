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
		String hql = "from Book";
		Query q = session.createQuery(hql);
		q.setFirstResult((page-1)*pageSize);
		q.setMaxResults(pageSize);
		
		List<Book> books = q.list();
		session.close();
		return books;
	}

	public void delete(int bid) {
		
		Session session = HibernateUtils.getSession();
		String hql = "delete from Book where id = ?";
		Query q = session.createQuery(hql);
		q.setInteger(0, bid);
		q.executeUpdate();
		session.beginTransaction().commit();
		session.close();
		
		// TODO Auto-generated method stub

	}

	public void update(Book cbook) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSession();
		String hql = "update Book b set b.name=?,b.price=?,b.count=?,b.author=? where b.id=?";
		Query q = session.createQuery(hql);
		q.setString(0, cbook.getName());
		q.setFloat(1, cbook.getPrice());
		q.setInteger(2, cbook.getCount());
		q.setString(3, cbook.getAuthor());
		
		q.executeUpdate();
		
		session.beginTransaction().commit();
		session.close();
	}

	public void addbook(Book nbook) {
		Session session = HibernateUtils.getSession();
		session.save(nbook);
		session.beginTransaction().commit();
		session.close();
		// TODO Auto-generated method stub

	}

	public int findBookTotalPage(int pageSize) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSession();
		String hql = "select count(*) from Book";
		Query q = session.createQuery(hql);
		List list = q.list();
		int row = Integer.valueOf(list.get(0).toString());
		
		if(row%pageSize==0) {
			return row/pageSize;
		}else {
			return row/pageSize+1;
		}
	
	}
	
	public Book seachone(int bid){
		Session session = HibernateUtils.getSession();
		String hql = "from Book where id=?";
		Query q = session.createQuery(hql);
		q.setInteger(0, bid);
		return ( (Book) q.list().get(0) );
	}

}
