package com.einfochips.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.einfochips.dao.BookDao;
import com.einfochips.model.Book;

@Service("bookService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookDao bookDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addBook(Book book) {
		bookDao.addBook(book);
	}
	
	public List<Book> listBooks() {
		return bookDao.listBooks();
	}

	public Book getBook(int bookid) {
		return bookDao.getBook(bookid);
	}
	
	public void deleteBook(Book book) {
		bookDao.deleteBook(book);
	}


}
