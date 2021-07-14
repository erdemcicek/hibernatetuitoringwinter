package h06.lazyfetch_eagerfetch;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave06 {
	
	public static void main(String[] args) {
		
		/*
		 			Advantages of LAZY FETCH:
		 1)Initial load time much smaller than “Eager Fetch” approach
		 2)Less memory consumption than “Eager Fetch” approach
		 
		 
		 			Disadvantages of EAGER FETCH:
		 1)Long initial loading time
		 2)Loading too much unnecessary data might impact performance and memory badly
		 
		 Note: 1) Hibernate works in lazy fetch as default
		 	   2) To convert Lazy Fetch to Eager Fetch you should type "fetch=FetchType.EAGER" into 
		 	   		@OneToMany() or @ManyToOne()
		 	   3) If you type "fetch=FetchType.EAGER" into @OneToMany() all fetches will behave like Eager Fetch
		 	   	  If you type "fetch=FetchType.EAGER" into @ManyToOne() fetches from child class
		 	   	  		will behave like Eager Fetch, fetches from parent class will behave like Lazy Fetch
		 */
		
		Books06 books1 = new Books06();
		Books06 books2 = new Books06();
		Books06 books3 = new Books06();
		Students06 student = new Students06();
		
		student.setId(1005);
		student.setName("Beyhan Can");
		student.setGrade(11);

		books1.setBook(student.getName() + "'s art book");
		books1.setId(101);
		books1.setStudent(student);
		
		books2.setBook(student.getName() + "'s math book");
		books2.setId(102);
		books2.setStudent(student);
		
		books3.setBook(student.getName() + "'s science book");
		books3.setId(103);
		books3.setStudent(student);
		
		student.getBooksList().add(books1);
		student.getBooksList().add(books2);
		student.getBooksList().add(books3);	

		Configuration con = new Configuration().
									configure("hibernate.cfg.xml").
									addAnnotatedClass(Students06.class).
									addAnnotatedClass(Books06.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		session.save(student);
		session.save(books1);
		session.save(books2);
		session.save(books3);
		
		tx.commit();
	}
}
