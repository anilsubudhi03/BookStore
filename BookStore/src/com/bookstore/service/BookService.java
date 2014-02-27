package com.bookstore.service;

import java.util.List;

import javax.ws.rs.core.UriInfo;

import com.bookstore.entity.Book;

public interface BookService {
	
	public void createNewBook(UriInfo info);
	
	public void updateBook(UriInfo info);
	
	public void deleteBook(int id);
	
	public List<Book> getAllBook();
	
	public Book getById(int id);
	
}
