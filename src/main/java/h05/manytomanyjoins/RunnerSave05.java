package h05.manytomanyjoins;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave05 {

	public static void main(String[] args) {
		
		Books05 b1 = new Books05(11, "Math Book");
		Books05 b2 = new Books05(12, "Science Book");
		Books05 b3 = new Books05(13, "Java Book");
		Books05 b4 = new Books05(14, "Art Book");
		
		List<Books05> booksList1 = new ArrayList<>();
		booksList1.add(b1);
		booksList1.add(b2);
		booksList1.add(b4);
		
		List<Books05> booksList2 = new ArrayList<>();
		booksList2.add(b2);
		booksList2.add(b3);
		booksList2.add(b4);
		
		Students05 s1 = new Students05(101, "Ali Can", 8, booksList1);
		Students05 s2 = new Students05(102, "Veli Han", 9, booksList2);
		
		List<Students05> studentsList1 = new ArrayList<>();
		studentsList1.add(s1);
		b1.setStudentList(studentsList1);
		
		List<Students05> studentsList2 = new ArrayList<>();
		studentsList2.add(s1);
		studentsList2.add(s2);
		b2.setStudentList(studentsList2);
		
		List<Students05> studentsList3 = new ArrayList<>();
		studentsList3.add(s2);
		b3.setStudentList(studentsList3);
		
		List<Students05> studentsList4 = new ArrayList<>();
		studentsList4.add(s1);
		studentsList4.add(s2);
		b4.setStudentList(studentsList4);
		
		Configuration con = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Students05.class).
				addAnnotatedClass(Books05.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(b1);
		session.save(b2);
		session.save(b3);
		session.save(b4);
		
		session.save(s1);
		session.save(s2);
		
		
		tx.commit();
		

	}
}
