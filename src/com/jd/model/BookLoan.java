package com.jd.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the book_loan database table.
 * 
 */
@Entity
@Table(name="book_loan")
@NamedQuery(name="BookLoan.findAll", query="SELECT b FROM BookLoan b")
public class BookLoan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfIssue;

	private byte isReturned;

	//bi-directional many-to-one association to BookHO
	@ManyToOne
	@JoinColumn(name="book_id")
	private BookHO book;

	//bi-directional many-to-one association to LibraryEmployee
	@ManyToOne
	@JoinColumn(name="loan_by_employee_id")
	private LibraryEmployee libraryEmployee;

	//bi-directional many-to-one association to Student
	@ManyToOne
	//@JoinColumn(name="studentId")
	private Student student;

	public BookLoan() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateOfIssue() {
		return this.dateOfIssue;
	}

	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public byte getIsReturned() {
		return this.isReturned;
	}

	public void setIsReturned(byte isReturned) {
		this.isReturned = isReturned;
	}

	public BookHO getBook() {
		return this.book;
	}

	public void setBook(BookHO book) {
		this.book = book;
	}

	public LibraryEmployee getLibraryEmployee() {
		return this.libraryEmployee;
	}

	public void setLibraryEmployee(LibraryEmployee libraryEmployee) {
		this.libraryEmployee = libraryEmployee;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}