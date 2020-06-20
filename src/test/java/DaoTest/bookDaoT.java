package DaoTest;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import cn.edu.xaut.entity.Book;
import cn.edu.xaut.utils.HibernateUtils;

public class bookDaoT {
	
	@Test
	public void findBookByPage() {
		// TODO Auto-generated method stub
		int page=1,pageSize=2;
		Session session = HibernateUtils.getSession();
		String hql = "from Book";
		Query query = session.createQuery(hql);
		query.setFirstResult((page-1)*pageSize);
		query.setMaxResults(pageSize);
		
		List<Book> books = query.list();
		session.close();
		for (Book book : books) {
			System.out.println(book);
		}
	}
	
	@Test
	public void deletebook() {
		Session session = HibernateUtils.getSession();
		String hql = "delete from Book where bid = 105";
		Query query = session.createQuery(hql);
		query.executeUpdate();
		session.beginTransaction().commit();
		session.close();
	}
	
	@Test
	public void update() {
		Session session = HibernateUtils.getSession();
		String hql = "update Book u set u.name=?,u.price=?,u.count=?,u.author=? where u.id=?";
		Query q = session.createQuery(hql);
		q.setString(0, "tushu");
		q.setFloat(1, 22.5f);
		q.setInteger(2, 10);
		q.setString(3, "zuohe");
		q.setInteger(4, 105);
		
		q.executeUpdate();
		
		session.beginTransaction().commit();
		session.close();
	}
	
	@Test
	public void save() {
		Book book1 = new Book(1,"tushu",72.5f,20,"zuozhe");
		Session session = HibernateUtils.getSession();
		session.save(book1);
		session.beginTransaction().commit();
	}
	
	@Test
	public void total() {
		Session session = HibernateUtils.getSession();
		String hql = "select count(*) from Book";
		Query query = session.createQuery(hql);
		List list = query.list();
		int row = Integer.valueOf(list.get(0).toString());
		
		System.out.println(row);
	}
	
	@Test
	public void seachone() {
		Session session = HibernateUtils.getSession();
		String hql = "from Book where id=?";
		Query q = session.createQuery(hql);
		q.setInteger(0, 104);
		System.out.println(q.list().get(0));
	}
	
}

