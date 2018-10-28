package com.jd.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.util.Set;


/**
 * The persistent class for the book database table.
 * 
 */
@Entity
@Table(name="book")
@NamedQuery(name="BookHO.findAll", query="SELECT b FROM BookHO b")
public class BookHO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int isbn;

	private String edision;

	private String name;

	@Column(name="number_of_book_available")
	private int numberOfBookAvailable;

	//bi-directional many-to-one association to BookAuthor
	@ManyToOne
	//@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name="author_id")
	private BookAuthor bookAuthor;

	//bi-directional many-to-one association to BookCategory
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name="category_id")
	private BookCategory bookCategory;

	//bi-directional many-to-one association to Publisher
	@ManyToOne
	private Publisher publisher;

	//bi-directional many-to-one association to BookLoan
	@OneToMany(mappedBy="book",cascade=CascadeType.ALL)
	//@JoinColumn(name="isbn")
	private Set<BookLoan> bookLoans;

	public BookHO() {
	}

	public int getIsbn() {
		return this.isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getEdision() {
		return this.edision;
	}

	public void setEdision(String edision) {
		this.edision = edision;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfBookAvailable() {
		return this.numberOfBookAvailable;
	}

	public void setNumberOfBookAvailable(int numberOfBookAvailable) {
		this.numberOfBookAvailable = numberOfBookAvailable;
	}

	public BookAuthor getBookAuthor() {
		return this.bookAuthor;
	}

	public void setBookAuthor(BookAuthor bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public BookCategory getBookCategory() {
		return this.bookCategory;
	}

	public void setBookCategory(BookCategory bookCategory) {
		this.bookCategory = bookCategory;
	}

	public Publisher getPublisher() {
		return this.publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Set<BookLoan> getBookLoans() {
		return this.bookLoans;
	}

	public void setBookLoans(Set<BookLoan> bookLoans) {
		this.bookLoans = bookLoans;
	}

	public BookLoan addBookLoan(BookLoan bookLoan) {
		getBookLoans().add(bookLoan);
		bookLoan.setBook(this);

		return bookLoan;
	}

	public BookLoan removeBookLoan(BookLoan bookLoan) {
		getBookLoans().remove(bookLoan);
		bookLoan.setBook(null);

		return bookLoan;
	}

}