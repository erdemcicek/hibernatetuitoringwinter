package h04.onetomanyjoins;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Students04 {
	
	@Id
	private int student_id;
	
	@Column(name="student_name")
	private String name;
	
	@Column(name="student_grade")
	private int grade;
	
	/*
	 	Note: In parent class;
	 	When you create booksList create getter() and setter()
	 	Put the booksList into parameterized constructor,
	 	Put the booksList into toString() method.
	 */
	
	@OneToMany(mappedBy="student", orphanRemoval = true, cascade=CascadeType.ALL)
	List<Books04> booksList = new ArrayList<>();
	
	public Students04() {};

	public Students04(int student_id, String name, int grade) {
		this.student_id = student_id;
		this.name = name;
		this.grade = grade;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public List<Books04> getBooksList() {
		return booksList;
	}

	public void setBooksList(List<Books04> booksList) {
		this.booksList = booksList;
	}

	@Override
	public String toString() {
		return "Students04 [student_id=" + student_id + ", name=" + name + ", grade=" + grade + ", booksList=" + booksList
				+ "]";
	}

	
	
	
	

}
