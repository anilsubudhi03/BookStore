package com.bookstore.dao.impl;

import java.util.List;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bookstore.dao.BookDao;
import com.bookstore.entity.Book;

public class BookDaoImpl implements BookDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void add(UriInfo info) {
		MultivaluedMap<String, String> values = info.getQueryParameters();
		getJdbcTemplate()
				.update("INSERT INTO BOOKS(TITLE,CATEGORY_ID,AUTH_ID) VALUES(?,?,?)",
						new Object[] { values.getFirst("title"),
								values.getFirst("category"),
								values.getFirst("author") });
	}

	@Override
	public void delete(int id) {
		getJdbcTemplate().update("DELETE FROM BOOKS WHERE BOOK_ID=?",
				new Object[] { id });
	}

	@Override
	public void edit(UriInfo info) {
		MultivaluedMap<String, String> values = info.getQueryParameters();
		getJdbcTemplate().update(
				"UPDATE BOOKS SET TITLE=?,CATEGORY_ID=?,AUTH_ID=? WHERE BOOK_ID=?",
				new Object[] { values.getFirst("title"),
						values.getFirst("category"), values.getFirst("author"),
						values.getFirst("bookId") });
	}

	@Override
	public Book getById(int id) {
		Book book = getJdbcTemplate()
				.queryForObject(
						"SELECT B.BOOK_ID,B.TITLE,C.CATEGORY_ID,C.CATEGORY_NAME,A.AUTH_ID,A.AUTH_NAME,A.AUTH_LASTNAME,A.BIRTHDAY FROM BOOKS B JOIN AUTHOR A ON B.AUTH_ID=A.AUTH_ID JOIN CATEGORY C ON C.CATEGORY_ID=B.CATEGORY_ID "
								+ " WHERE BOOK_ID=?", new Object[] { id },
						new BeanPropertyRowMapper<Book>(Book.class));
		return book;
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
				.query("SELECT B.BOOK_ID,B.TITLE,C.CATEGORY_ID,C.CATEGORY_NAME,A.AUTH_ID,A.AUTH_NAME,A.AUTH_LASTNAME,A.BIRTHDAY FROM BOOKS B JOIN AUTHOR A ON B.AUTH_ID=A.AUTH_ID JOIN CATEGORY C ON C.CATEGORY_ID=B.CATEGORY_ID",
						new BeanPropertyRowMapper<Book>(Book.class));
	}

}
