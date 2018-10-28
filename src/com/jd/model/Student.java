package com.jd.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@Column(name="studentId")
	private int id;
	
	

/*	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}*/

	private String email;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	private String password;

	@Column(name="phone_number")
	private String phoneNumber;

	//bi-directional many-to-one association to BookLoan
	@OneToMany(mappedBy="student")
	private Set<BookLoan> bookLoans;

	
	public Student() {
	}

/*	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}*/

	public String getEmail() {
		return this.email;
	}

/*	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}*/
	

	public void setEmail(String email) {
		this.email = email;
	}
/*
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
*/
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/*public Set<BookLoan> getBookLoans() {
		return this.bookLoans;
	}

	public void setBookLoans(Set<BookLoan> bookLoans) {
		this.bookLoans = bookLoans;
	}*/
	

	public BookLoan addBookLoan(BookLoan bookLoan) {
		getBookLoans().add(bookLoan);
		bookLoan.setStudent(this);

		return bookLoan;
	}

	public Set<BookLoan> getBookLoans() {
		return bookLoans;
	}

	public void setBookLoans(Set<BookLoan> bookLoans) {
		this.bookLoans = bookLoans;
	}

	public BookLoan removeBookLoan(BookLoan bookLoan) {
		getBookLoans().remove(bookLoan);
		bookLoan.setStudent(null);

		return bookLoan;
	}

}