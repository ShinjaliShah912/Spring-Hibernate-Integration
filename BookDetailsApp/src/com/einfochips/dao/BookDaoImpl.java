package com.einfochips.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.einfochips.dao.BookDao;
import com.einfochips.model.Book;



@Repository("bookDao")
public class BookDaoImpl implements BookDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addBook(Book book) {
		sessionFactory.getCurrentSession().saveOrUpdate(book);
	}

	@SuppressWarnings("unchecked")
	public List<Book> listBooks() {
		return (List<Book>) sessionFactory.getCurrentSession().createCriteria(Book.class).list();
	}

	public Book getBook(int bookid) {
		return (Book) sessionFactory.getCurrentSession().get(Book.class, bookid);
	}

	public void deleteBook(Book book) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Book WHERE bookid = "+book.getBookId()).executeUpdate();
	}


}
