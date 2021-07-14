package h04.onetomanyjoins;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch04 {
	
	public static void main(String[] args) {
		
		Students04 stdRead = new Students04();
		Books04 bRead = new Books04();
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Students04.class).
				addAnnotatedClass(Books04.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		// 1) Fetch all books of a student whose id is 101 by using get() method
		
				// 1.Step: Get the expected student
//		stdRead = session.get(Students04.class, 101);
//		
//				// 2.Step: Get the books of the student by using getter() 
//		List<Books04> bookList = new ArrayList<>();
//		for(Books04 w : bookList) System.out.println(w);
		
		
		
		
		// 2) Fetch the owner of a book whose id is 11 by using get() method
		
				// 1.Step: Get the expected book
//		bRead = session.get(Books04.class, 11);
//		
//				// 2.Step: Get the student of the book by using getter()
//		stdRead = bRead.getStudent();
//		System.out.println(stdRead);
		
		
		// 3) Fetch student name, book name of common records from Students04 and Books04 tables (INNER JOIN)
		
				// 1.Way: SQL Query
		// Note: In SQL, you can use createSQLQuery() or createNativeQuery() . Both work.
		//		 But in HQL, you have to use createQuery()
//		String sql3 = "SELECT s.student_name, b.book_name FROM students s INNER JOIN books b ON s.student_id = b.student_id";
//		List<Object[]> resultList3a = session.createSQLQuery(sql3).getResultList();
//		for(Object[] w : resultList3a) System.out.println(Arrays.toString(w));
		
				// 2.Way: HQL Query
//		String hql3 = "SELECT s.name, b.book_name FROM Students04 s INNER JOIN Books04 b ON s.student_id = b.student";
//		List<Object[]> resultList3b = session.createQuery(hql3).getResultList();
//		for(Object[] w : resultList3b) System.out.println(Arrays.toString(w));
		
		
		// 4) Fetch student name, book name of all records from Students04 and Books04 table (FULL JOIN)
		
				// 1.Way: SQL Query
//		String sql4 = "SELECT s.student_name, b.book_name FROM students s FULL JOIN books b ON s.student_id = b.student_id";
//		List<Object[]> resultList4a = session.createSQLQuery(sql4).getResultList();
//		resultList4a.stream().forEach(t->System.out.println(Arrays.toString(t)));
		
				// 2.Way: HQL Query
//		String hql4 = "SELECT s.name, b.book_name FROM Students04 s FULL JOIN Books04 b ON s.student_id = b.student";
//		List<Object[]> resultList4b = session.createQuery(hql4).getResultList();
//		resultList4b.stream().forEach(t->System.out.println(Arrays.toString(t)));
		
		
		
		// How to delete all records from a table ?
		
		// 5) Delete all records from child table
				// 1.Way: SQL Query
//		String sqlDel1 = "DELETE FROM books";
//		int d1 = session.createSQLQuery(sqlDel1).executeUpdate();
//		System.out.println(d1 + " record" + ((d1==1)?(" is"):("s are")) + " deleted");
		
		// 6) Delete all records from parent table
				// 1.Way: SQL Query
//		String sqlDel2 = "DELETE FROM students";
//		int d2 = session.createSQLQuery(sqlDel2).executeUpdate();
//		System.out.println(d2 + " record" + ((d2==1)?(" is"):("s are")) + " deleted");
		/* 	
		   Note : This one gave error. Because, in Hibernate you cannot delete records from parent class before those of child class
						Error message: integrity constraint violated - child record found
		
		 	If you insist on deleting records from parent table you have 2 options;
		 	 	a) Delete child records first then delete parent records
		 	 	b) By using annotation we can tell to Hibernate like;
		 	 			If I delete parent, delete child
		 */
		
		
//		session.delete(session.get(Students04.class, 101));
//		Books04 book = session.get(Books04.class, 14);
//		session.delete(book);
//		session.delete("Books04", book);
		
		
		// c) Without touching Child Table delete records from Parent Table and from Child Table
		
				// How to get a specific field values from a table
//		int max = Integer.MAX_VALUE;
//		String hqlQuery = "FROM Students04 WHERE student_id < " + max ;
//		List<Students04> resultList = session.createQuery(hqlQuery).getResultList();
//		for(Students04 w : resultList) System.out.println(w.getStudent_id());
		
		
		// c) Without touching Child Table delete records from Parent Table and from Child Table
		
//		int max = Integer.MAX_VALUE;
//		String hqlQuery = "FROM Students04 WHERE student_id < " + max ;
//		List<Students04> resultList = session.createQuery(hqlQuery).getResultList();
//		for(Students04 w : resultList) {
//			Students04 student = session.get(Students04.class, w.getStudent_id());
//			session.delete(student);
//		}
		
		
		// How to update data by using Hibernate?
		
		// 6) Update the name of the student whose id is 11 to Mark Stone
		
				// 1.Way
//		String hql6 = "UPDATE Students04 s SET s.name = 'Mark Stone' WHERE s.student_id=101";
//		int ur6 = session.createQuery(hql6).executeUpdate();
//		System.out.println(ur6 + ((ur6==1)?(" row is "):(" rows are ")) + " updated");
		
				// 2.Way
//		Students04 student = session.get(Students04.class, 101);
//		student.setName("Angie Star");
//		System.out.println(student);
		
		
		// 7) Update the grades of the students to 12 whose grades are greater than 8
	
//		String hql7 = "UPDATE Students04 s SET s.grade = 12 WHERE s.grade > 8";
//		int ur7 = session.createQuery(hql7).executeUpdate();
//		System.out.println(ur7 + ((ur7==1)?(" row is "):(" rows are ")) + " updated");
		
		
		// 8) Update the names of students whose grades are less than 11 to "Junior"
		
		String hql8 = "UPDATE Students04 s SET s.name = 'Junior' WHERE s.grade < 11";
		int ur8 = session.createQuery(hql8).executeUpdate();
		System.out.println(ur8 + ((ur8==1)?(" row is "):(" rows are ")) + " updated");
		
		
		
		
		tx.commit();
	}

}
