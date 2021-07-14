package h06.lazyfetch_eagerfetch;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Students06 {
	
	@Id
	private int id;
	
	@Column(name="students_name")
	private String name;
	private int grade;
	
	@OneToMany(mappedBy="student", fetch=FetchType.EAGER)
	private List<Books06> booksList = new ArrayList<Books06>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public List<Books06> getBooksList() {
		return booksList;
	}
	public void setBooksList(List<Books06> booksList) {
		this.booksList = booksList;
	}
	@Override
	public String toString() {
		return "Students06 [id=" + id + ", name=" + name + ", grade=" + grade + "]";
	}

}
