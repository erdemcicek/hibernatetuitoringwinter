package h05.manytomanyjoins;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

@Entity
public class Students05 {
	
	@Id
	private int std_id;
	@Column(name="student_name")
	private String name;
	private int grade;
	
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Students05_Books05", joinColumns= {@JoinColumn(name="std_id")}, inverseJoinColumns= {@JoinColumn(name="book_id")})
	private List<Books05> booksList = new ArrayList<>();
	
	public Students05() {};
	
	public Students05(int std_id, String name, int grade, List<Books05> booksList) {
		this.std_id = std_id;
		this.name = name;
		this.grade = grade;
		this.booksList = booksList;
	}

	public int getStd_id() {
		return std_id;
	}

	public void setStd_id(int std_id) {
		this.std_id = std_id;
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

	public List<Books05> getBooksList() {
		return booksList;
	}

	public void setBooksList(List<Books05> booksList) {
		this.booksList = booksList;
	}

	@Override
	public String toString() {
		return "Students05 [std_id=" + std_id + ", name=" + name + ", grade=" + grade + "]";
	}

	

//	@Override
//	public String toString() {
//		return "Students05 [std_id=" + std_id + ", name=" + name + ", grade=" + grade + ", booksList=" + booksList
//				+ "]";
//	}

	

	
	
	

}
