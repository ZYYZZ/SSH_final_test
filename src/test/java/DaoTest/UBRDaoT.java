package DaoTest;

import org.hibernate.Session;
import org.junit.Test;

import cn.edu.xaut.entity.UBR;
import cn.edu.xaut.utils.HibernateUtils;

public class UBRDaoT {
	
	@Test
	public void insert() {
		long limit = 2592000000l;
		int type = 1;
		if(Long.valueOf("1564166637133")-(System.currentTimeMillis())>limit){
			type = 0;
		}
		Session session = HibernateUtils.getSession();
		UBR ubr = new UBR();
		ubr.setBid(105);	ubr.setType(type);
		ubr.setBname("jisuanji");
		ubr.setUname("asd123");
		ubr.setRtime(String.valueOf(System.currentTimeMillis()));
		session.save(ubr);
		session.beginTransaction().commit();
		session.close();
		System.out.println(System.currentTimeMillis());
	}
}
