package com.jd.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the book_author database table.
 * 
 */
@Entity
@Table(name="book_author")
//@NamedQuery(name="BookAuthor.findAll", query="SELECT b FROM BookAuthor b")
public class BookAuthor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String email;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="pen_name")
	private String penName;

	//bi-directional many-to-one association to BookHO
	@OneToMany(mappedBy="bookAuthor",cascade=CascadeType.ALL)
	private Set<BookHO> books;

	public BookAuthor() {
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

	public String getPenName() {
		return this.penName;
	}

	public void setPenName(String penName) {
		this.penName = penName;
	}

	public Set<BookHO> getBooks() {
		return this.books;
	}

	public void setBooks(Set<BookHO> books) {
		this.books = books;
	}

	public BookHO addBook(BookHO book) {
		getBooks().add(book);
		book.setBookAuthor(this);

		return book;
	}

	public BookHO removeBook(BookHO book) {
		getBooks().remove(book);
		book.setBookAuthor(null);

		return book;
	}

}