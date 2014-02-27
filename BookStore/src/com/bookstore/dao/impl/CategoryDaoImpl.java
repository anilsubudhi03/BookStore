package com.bookstore.dao.impl;

import java.util.List;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bookstore.dao.CategoryDao;
import com.bookstore.entity.Book;

public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void add(UriInfo info) {
		MultivaluedMap<String, String> values = info.getQueryParameters();
		getJdbcTemplate().update(
				"INSERT INTO CATEGORY(CATEGORY_NAME) VALUES(?)",
				new Object[] { values.getFirst("categoryName") });
	}

	@Override
	public void delete(int id) {
		getJdbcTemplate().update("DELETE FROM CATEGORY WHERE CATEGORY_ID=?",
				new Object[] { id });
	}

	@Override
	public void edit(UriInfo info) {
		MultivaluedMap<String, String> values = info.getQueryParameters();
		getJdbcTemplate().update(
				"UPDATE CATEGORY SET CATEGORY_NAME=? WHERE CATEGORY_ID=?",
				new Object[] { values.getFirst("categoryName"),values.getFirst("categoryId") });
	}

	@Override
	public Book getById(int id) {
		Book cate = getJdbcTemplate().queryForObject(
				"SELECT * FROM CATEGORY WHERE CATEGORY_ID=?",
				new Object[] { id },
				new BeanPropertyRowMapper<Book>(Book.class));
		return cate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Book> getAll() {
		return getJdbcTemplate()
				.query("SELECT * FROM CATEGORY",
						new BeanPropertyRowMapper<Book>(Book.class));
	}
}
