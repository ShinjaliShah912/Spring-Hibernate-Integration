package com.einfochips.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.einfochips.bean.BookBean;
import com.einfochips.model.Book;
import com.einfochips.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveBook(@ModelAttribute("command") BookBean bookBean, BindingResult result) {
		Book book = prepareModel(bookBean);
		bookService.addBook(book);
		return new ModelAndView("redirect:/add.html");
	}

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public ModelAndView listBooks() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("books", prepareListofBean(bookService.listBooks()));
		return new ModelAndView("booksList", model);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addBook(@ModelAttribute("command") BookBean bookBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("books", prepareListofBean(bookService.listBooks()));
		return new ModelAndView("addBook", model);
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView editBook(@ModelAttribute("command") BookBean bookBean, BindingResult result) {
		bookService.deleteBook(prepareModel(bookBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("book", null);
		model.put("books", prepareListofBean(bookService.listBooks()));
		return new ModelAndView("addBook", model);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView deleteBook(@ModelAttribute("command") BookBean bookBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("book", prepareBookBean(bookService.getBook(bookBean.getId())));
		model.put("books", prepareListofBean(bookService.listBooks()));
		return new ModelAndView("addBook", model);
	}

	private Book prepareModel(BookBean bookBean) {
		Book book = new Book();
		book.setBookAuthor(bookBean.getAuthor());
		book.setBookEdition(bookBean.getEdition());
		book.setBookName(bookBean.getName());
		book.setBookPrice(bookBean.getPrice());
		book.setBookId(bookBean.getId());
		bookBean.setId(null);
		return book;
	}

	private List<BookBean> prepareListofBean(List<Book> books) {
		List<BookBean> beans = null;
		if (books != null && !books.isEmpty()) {
			beans = new ArrayList<BookBean>();
			BookBean bean = null;
			for (Book book : books) {
				bean = new BookBean();
				bean.setName(book.getBookName());
				bean.setId(book.getBookId());
				bean.setAuthor(book.getBookAuthor());
				bean.setPrice(book.getBookPrice());
				bean.setEdition(book.getBookEdition());
				beans.add(bean);
			}
		}
		return beans;
	}

	private BookBean prepareBookBean(Book book) {
		BookBean bean = new BookBean();
		bean.setAuthor(book.getBookAuthor());
		bean.setEdition(book.getBookEdition());
		bean.setName(book.getBookName());
		bean.setPrice(book.getBookPrice());
		bean.setId(book.getBookId());
		return bean;
	}

}
