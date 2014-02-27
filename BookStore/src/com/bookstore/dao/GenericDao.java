package com.bookstore.dao;

import java.util.List;

import javax.ws.rs.core.UriInfo;

import com.bookstore.entity.Book;

public interface GenericDao {

	public void add(UriInfo info);

	public void delete(int id);

	public void edit(UriInfo info);

	public Book getById(int id);
	
	public List<Book> getAll();

}
