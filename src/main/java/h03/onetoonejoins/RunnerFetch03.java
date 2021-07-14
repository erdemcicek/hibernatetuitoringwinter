package h03.onetoonejoins;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch03 {

	public static void main(String[] args) {
		
		Students03 stdRead = new Students03();
		Diary dRead = new Diary();
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students03.class)
				.addAnnotatedClass(Diary.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		// 1) Fetch the student whose id is 101 by using get()
//		stdRead = session.get(Students03.class, 101);
		
		// 2) Fetch the diary details of a student whose id is 12 by using get()
		// If you use non-primary key values in get(), it returns "null"
		dRead = session.get(Diary.class, 12);
		System.out.println(dRead);
		
		// 3) Fetch student name, diary name and student grade of common records from Students03 and Diary tables
		// 1.Way: SQL Queries
//		String sql3 = "SELECT s.student_name, d.diary, s.grade FROM Students03 s JOIN Diary d ON s.student_id = d.student_id";
//		
//		List<Object[]> resultList3a = session.createSQLQuery(sql3).getResultList();
//		resultList3a.stream().forEach(t->System.out.println(Arrays.toString(t)));
		
		// 2.Way: HQL Queries
		// When you HQL Queries, you have to get all names from variables, classes, etc.
		// Do not use table related values in HQL Query
//		String hql3 = "SELECT s.name, d.diary, s.grade FROM Students03 s JOIN Diary d ON s.student_id = d.student";
//		
//		List<Object[]> resultList3b = session.createQuery(hql3).getResultList();
//		resultList3b.stream().forEach(t->System.out.println(Arrays.toString(t)));
		
		// 4) Fetch student name, diary name and student grade of records from Students03 table
		// 1.Way: SQL Queries
//		String sql4 = "SELECT s.student_name, d.diary, s.grade FROM Students03 s LEFT JOIN Diary d ON s.student_id = d.student_id";
//		List<Object[]> resultList4a = session.createSQLQuery(sql4).getResultList();
//		resultList4a.stream().forEach(t->System.out.println(Arrays.toString(t)));
		
		// 2.Way: HQL Queries
//		String hql4 = "SELECT name, diary, grade FROM Students03 LEFT JOIN Diary ON student_id = student";
//		List<Object[]> resultList4b = session.createQuery(hql4).getResultList();
//		resultList4b.stream().forEach(t->System.out.println(Arrays.toString(t)));
		
		// 5) Fetch student name, diary name and student grade of records from Diary table
		
//		String sql5 = "SELECT s.student_name, d.diary, s.grade FROM Students03 s RIGHT JOIN Diary d ON s.student_id = d.student_id";
//		List<Object[]> resultList5a = session.createSQLQuery(sql5).getResultList();
//		resultList5a.stream().forEach(t->System.out.println(Arrays.toString(t)));
		
//		String hql5 = "SELECT s.name, d.diary, s.grade FROM Students03 s RIGHT JOIN Diary d ON s.student_id = d.student";
//		List<Object[]> resultList5b = session.createQuery(hql5).getResultList();
//		resultList5b.stream().forEach(t->System.out.println(Arrays.toString(t)));
		
		// 6) Fetch student name, diary name and student grade of all records from Students03 and Diary table
		// 1.Way
//		String sql6 = "SELECT s.student_name, d.diary, s.grade FROM Students03 s FULL JOIN Diary d ON s.student_id = d.student_id";
//		List<Object[]> resultList6a = session.createSQLQuery(sql6).getResultList();
//		resultList6a.stream().forEach(t->System.out.println(Arrays.toString(t)));
		
		// 2.Way
//		String hql6 = "SELECT s.name, d.diary, s.grade FROM Students03 s FULL JOIN Diary d ON s.student_id = d.student";
//		List<Object[]> resultList6b = session.createQuery(hql6).getResultList();
//		resultList6b.stream().forEach(t->System.out.println(Arrays.toString(t)));
		
		// 7) Fetch all students information of common records from Students03 and Diary table
		// 1.Way: SQL Query
		// Note: If you have duplicated columns in different table, to fetch all records do not use "*"
		//       Type column names one by one with the aliases
//		String sql7 = "SELECT * FROM Students03 s INNER JOIN Diary d ON s.student_id = d.student_id";
//		List<Object[]> resultList7a = session.createSQLQuery(sql7).getResultList();
//		resultList7a.stream().forEach(t->System.out.println(Arrays.toString(t)));
		// Because of duplicated column names the code above gave error. Convineint way
		/*
		  String sql7 = "SELECT s.student_id, s.grade, s.student_name, d.id, d.dairy FROM Students03 s INNER JOIN Dairy d ON s.student_id = d.student_id";
        List<Object[]> resultList7a = session.createSQLQuery(sql7).getResultList();
        for(Object[] w: resultList7a) {
            System.out.println(Arrays.toString(w));
        }
		 */
		
		// 2.Way: HQL Query
		// In HQL, if you want to get all data about records, no need to use "SELECT *", you can start from "FROM .." part
//		String hql7 = " FROM Students03 s INNER JOIN FETCH Diary d ON s.student_id = d.student";
//		List<Object[]> resultList7b = session.createQuery(hql7).getResultList();
//		resultList7b.stream().forEach(t->System.out.println(Arrays.toString(t)));
		
		// 8) Fetch all students information of all records from Students03 and Diary table
//		String hql8 = "FROM Students03 s FULL JOIN Diary d ON s.student_id = d.student";
//		List<Object[]> resultList8 = session.createQuery(hql8).getResultList();
//		resultList8.stream().forEach(t->System.out.println(Arrays.toString(t)));
		
		tx.commit();
		session.close();
		sf.close();
		
//		System.out.println(dRead);
	}
}
