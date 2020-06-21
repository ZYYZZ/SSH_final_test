package SpringTest;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.xaut.entity.Book;

public class sessionfactory {
	
	@Test
	public void getsessionFactory() {
		ApplicationContext cs = new ClassPathXmlApplicationContext("beans.xml");
		
		SessionFactory sessionFactory = (SessionFactory) cs.getBean("sessionFactory");
		
		Session session = sessionFactory.openSession();
		String hql = "from Book";
		Query query = session.createQuery(hql);
		
		List<Book> customers = query.list();
		for (Book customer : customers) {
			System.out.println(customer);
		}
	}
}
