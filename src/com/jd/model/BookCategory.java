package com.jd.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the book_category database table.
 * 
 */
@Entity
@Table(name="book_category")
@NamedQuery(name="BookCategory.findAll", query="SELECT b FROM BookCategory b")
public class BookCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	//bi-directional many-to-one association to BookHO
	@OneToMany(mappedBy="bookCategory")
	private Set<BookHO> books;

	public BookCategory() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<BookHO> getBooks() {
		return this.books;
	}

	public void setBooks(Set<BookHO> books) {
		this.books = books;
	}

	public BookHO addBook(BookHO book) {
		getBooks().add(book);
		book.setBookCategory(this);

		return book;
	}

	public BookHO removeBook(BookHO book) {
		getBooks().remove(book);
		book.setBookCategory(null);

		return book;
	}

}