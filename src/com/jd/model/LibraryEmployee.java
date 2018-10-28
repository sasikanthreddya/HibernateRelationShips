package com.jd.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the library_employee database table.
 * 
 */
@Entity
@Table(name="library_employee")
@NamedQuery(name="LibraryEmployee.findAll", query="SELECT l FROM LibraryEmployee l")
public class LibraryEmployee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String email;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	private String password;

	private String role;

	//bi-directional many-to-one association to BookLoan
	@OneToMany(mappedBy="libraryEmployee")
	private Set<BookLoan> bookLoans;

	public LibraryEmployee() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<BookLoan> getBookLoans() {
		return this.bookLoans;
	}

	public void setBookLoans(Set<BookLoan> bookLoans) {
		this.bookLoans = bookLoans;
	}

	public BookLoan addBookLoan(BookLoan bookLoan) {
		getBookLoans().add(bookLoan);
		bookLoan.setLibraryEmployee(this);

		return bookLoan;
	}

	public BookLoan removeBookLoan(BookLoan bookLoan) {
		getBookLoans().remove(bookLoan);
		bookLoan.setLibraryEmployee(null);

		return bookLoan;
	}

}