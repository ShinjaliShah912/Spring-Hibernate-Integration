package com.einfochips.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Book")
public class Book implements Serializable{
	
private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "bookid")
	private Integer bookId;
	
	@Column(name="bookname")
	private String bookName;
	
	@Column(name="bookauthor")
	private String bookAuthor;
	
	@Column(name="bookprice")
	private Integer bookPrice;
	
	@Column(name="bookedition")
	private Integer bookEdition;

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public Integer getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(Integer bookPrice) {
		this.bookPrice = bookPrice;
	}

	public Integer getBookEdition() {
		return bookEdition;
	}

	public void setBookEdition(Integer bookEdition) {
		this.bookEdition = bookEdition;
	}

}
