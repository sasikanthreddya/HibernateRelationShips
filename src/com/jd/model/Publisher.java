package com.jd.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the publisher database table.
 * 
 */
@Entity
@NamedQuery(name="Publisher.findAll", query="SELECT p FROM Publisher p")
public class Publisher implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="creation_date")
	private Date creationDate;

	private String name;

	//bi-directional many-to-one association to BookHO
	@OneToMany(mappedBy="publisher")
	private Set<BookHO> books;

	public Publisher() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
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
		book.setPublisher(this);

		return book;
	}

	public BookHO removeBook(BookHO book) {
		getBooks().remove(book);
		book.setPublisher(null);

		return book;
	}

}