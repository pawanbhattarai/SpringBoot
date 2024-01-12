/**
 * 
 */
package com.DeitySoft.eBookStore.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.Set;
import java.util.HashSet;


/**
 * @author pawan
 *
 */
@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String b_name;
	private String author;
	private String cover;
	private String book;
	private String whoUser;
	@OneToMany
    private Set<Category> categories = new HashSet<>();
	public Book() {
		
	}


	public Book(String b_name, String author, String cover, String book, String whoUser, Set<Category> categories) {
		super();
		this.b_name = b_name;
		this.author = author;
		this.cover = cover;
		this.book = book;
		this.whoUser = whoUser;
		this.categories = categories;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	public Set<Category> getCategories() {
		return categories;
	}
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public String getWhoUser() {
		return whoUser;
	}

	public void setWhoUser(String whoUser) {
		this.whoUser = whoUser;
	}


	
	
}
