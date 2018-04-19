package com.einfochips.service;

import java.util.List;

import com.einfochips.model.Book;


public interface BookService {
	
	public void addBook(Book book);

	public List<Book> listBooks();
	
	public Book getBook(int bookid);
	
	public void deleteBook(Book book);

}
