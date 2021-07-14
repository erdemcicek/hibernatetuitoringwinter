package h03.onetoonejoins;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave03 {
	
	public static void main(String[] args) {
		
		Diary d1 = new Diary(11, "First diary");
		Diary d2 = new Diary(12, "Second diary");
		Diary d3 = new Diary(13, "Third diary");
		
		Students03 std1 = new Students03(101, "Ali Can", 10, d1);
		Students03 std2 = new Students03(102, "Veli Han", 9, d2);
		Students03 std3 = new Students03(103, "Ayse Tan", 11, d3);
		
		d1.setStudent(std1);
		d2.setStudent(std2);
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Students03.class).
				addAnnotatedClass(Diary.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(d1);
		session.save(d2);
		session.save(d3);
		
		session.save(std1);
		session.save(std2);
		session.save(std3);
		
		tx.commit();
	}

}
