package h06.lazyfetch_eagerfetch;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch06 {

	public static void main(String[] args) {
		
		Configuration con = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Students06.class).
				addAnnotatedClass(Books06.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Books06 book = session.get(Books06.class, 1005);
		System.out.println(book);
		
		Students06 student = session.get(Students06.class, 1005);
		System.out.println(student);
		
		
		tx.commit();
		
	}
}
