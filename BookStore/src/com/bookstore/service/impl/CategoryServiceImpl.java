package com.bookstore.service.impl;

import java.util.List;

import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.dao.CategoryDao;
import com.bookstore.entity.Book;
import com.bookstore.service.CategoryService;
import com.bookstore.transaction.BookStoreTrx;

@BookStoreTrx
public class CategoryServiceImpl implements CategoryService {

	private static Logger log = Logger.getLogger(CategoryServiceImpl.class);

	@Autowired
	private CategoryDao categorydao;

	@Override
	public void createNewCategory(UriInfo info) {
		log.info("Creating new Category...");
		getCategorydao().add(info);
	}

	@Override
	public void updateCategory(UriInfo info) {
		log.info("Updating Category...");
		getCategorydao().edit(info);
	}

	@Override
	public void deleteCategory(int id) {
		log.info("Deleting Category...");
		getCategorydao().delete(id);
	}

	@Override
	public List<Book> getAllCategory() {
		log.info("Get All list of Category....");
		return getCategorydao().getAll();
	}

	public CategoryDao getCategorydao() {
		return categorydao;
	}

	public void setCategorydao(CategoryDao categorydao) {
		this.categorydao = categorydao;
	}

	@Override
	public Book getById(int id) {
		return getCategorydao().getById(id);
	}

}
