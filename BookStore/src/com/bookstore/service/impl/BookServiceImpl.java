package com.bookstore.service.impl;

import java.util.List;

import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.dao.BookDao;
import com.bookstore.entity.Book;
import com.bookstore.service.BookService;
import com.bookstore.transaction.BookStoreTrx;

@BookStoreTrx
public class BookServiceImpl implements BookService {

	private static Logger log = Logger.getLogger(BookServiceImpl.class);

	@Autowired
	private BookDao bookDao;

	@Override
	public void createNewBook(UriInfo info) {
		log.info("Creating new Book....");
		getBookDao().add(info);
	}

	@Override
	public void updateBook(UriInfo info) {
		log.info("Updating new Book....");
		getBookDao().edit(info);
	}

	@Override
	public void deleteBook(int id) {
		log.info("Deleting new Book....");
		getBookDao().delete(id);
	}

	@Override
	public List<Book> getAllBook() {
		log.info("All books....");
		return getBookDao().getAll();
	}

	@Override
	public Book getById(int id) {
		log.info("Get Book by ID....");
		return getBookDao().getById(id);
	}

	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

}
