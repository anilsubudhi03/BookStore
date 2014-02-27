package com.bookstore.service;

import java.util.List;

import javax.ws.rs.core.UriInfo;

import com.bookstore.entity.Book;

public interface AuthorService {
	

	public void createNewAuthor(UriInfo info);
	
	public void updateAuthor(UriInfo info);
	
	public void deleteAuthor(int id);
	
	public List<Book> getAllAuthor();
	
	public Book getById(int id);

}
