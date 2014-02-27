package com.bookstore.service.impl;

import java.util.List;

import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.dao.AuthorDao;
import com.bookstore.entity.Book;
import com.bookstore.service.AuthorService;
import com.bookstore.transaction.BookStoreTrx;

@BookStoreTrx
public class AuthorServiceImpl implements AuthorService {

	private static Logger log = Logger.getLogger(AuthorServiceImpl.class);

	@Autowired
	private AuthorDao authDao;
	
	
	@Override
	public void createNewAuthor(UriInfo info) {
		log.info("Creating new Author....");
		getAuthDao().add(info);
	}

	@Override
	public void updateAuthor(UriInfo info) {
		log.info("Updating Author....");
		getAuthDao().edit(info);
	}

	@Override
	public void deleteAuthor(int id) {
		log.info("Deleting Author....");
		getAuthDao().delete(id);
	}

	@Override
	public List<Book> getAllAuthor() {
		log.info("Returing list of  Author....");
		return getAuthDao().getAll();
	}

	public AuthorDao getAuthDao() {
		return authDao;
	}

	public void setAuthDao(AuthorDao authDao) {
		this.authDao = authDao;
	}

	@Override
	public Book getById(int id) {
		return getAuthDao().getById(id);
	}
	
	

}
