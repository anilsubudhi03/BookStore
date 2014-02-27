package com.bookstore.service;

import java.util.List;

import javax.ws.rs.core.UriInfo;

import com.bookstore.entity.Book;

public interface CategoryService {

	public void createNewCategory(UriInfo info);

	public void updateCategory(UriInfo info);

	public void deleteCategory(int id);

	public List<Book> getAllCategory();

	public Book getById(int id);

}
