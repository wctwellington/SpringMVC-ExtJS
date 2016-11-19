package br.com.projeto.util;

import org.hibernate.Session;
import org.junit.Test;

public class HibernateUtilTeste {

	@Test
	public void createSession() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.close();
		HibernateUtil.getSessionFactory().close();
	}
	
}
