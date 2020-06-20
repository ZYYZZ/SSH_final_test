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
		Session session1 = HibernateUtils.getSession();
		
		String hql1 = "from Book where id = ?";
		
		Query q1 = session1.createQuery(hql1);
		q1.setInteger(0, cbook.getId());
		
		session1.beginTransaction().commit();
		
		Book book = (Book) q1.list().get(0);
		session1.close();
		
		if(!cbook.getAuthor().equals("")) {
			book.setAuthor(cbook.getAuthor());
		}
		if(cbook.getCount()!=0) {
			book.setCount(cbook.getCount());
		}
		if(!cbook.getName().equals("")) {
			book.setName(cbook.getName());
		}
		if(cbook.getPrice()!=0) {
			book.setPrice(cbook.getPrice());
		}
		
		System.out.println(book.toString());
		
		Session session2 = HibernateUtils.getSession();
		
		String hql2 = "delete from Book where id = ?";
		Query q2 = session2.createQuery(hql2);
		q2.setInteger(0, cbook.getId());
		
		q2.executeUpdate();
		
		session2.save(book);
		
		session2.beginTransaction().commit();
		session2.close();
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
