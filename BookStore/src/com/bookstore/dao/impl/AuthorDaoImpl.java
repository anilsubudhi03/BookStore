package com.bookstore.dao.impl;

import java.util.List;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bookstore.dao.AuthorDao;
import com.bookstore.entity.Book;

public class AuthorDaoImpl implements AuthorDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void add(UriInfo info) {
		MultivaluedMap<String, String> values = info.getQueryParameters();
		getJdbcTemplate()
				.update("INSERT INTO AUTHOR(AUTH_NAME,AUTH_LASTNAME,BIRTHDAY) VALUES(?,?,?)",
						new Object[] { values.getFirst("authName"),
								values.getFirst("authLastName"),
								values.getFirst("birthDay") });
	}

	@Override
	public void delete(int id) {
		getJdbcTemplate().update("DELETE FROM AUTHOR WHERE AUTH_ID=?",
				new Object[] { id });
	}

	@Override
	public void edit(UriInfo info) {
		MultivaluedMap<String, String> values = info.getQueryParameters();
		getJdbcTemplate()
				.update("UPDATE AUTHOR SET AUTH_NAME=?,AUTH_LASTNAME=?,BIRTHDAY=? WHERE AUTH_ID=?",
						new Object[] { values.getFirst("authName"),
								values.getFirst("authLastName"),
								values.getFirst("birthDay"),
								values.getFirst("authId") });
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Book getById(int id) {
		Book auth = getJdbcTemplate().queryForObject(
				"SELECT * FROM AUTHOR WHERE AUTH_ID=?", new Object[] { id },
				new BeanPropertyRowMapper<Book>(Book.class));
		return auth;
	}

	@Override
	public List<Book> getAll() {
		return getJdbcTemplate().query("SELECT * FROM AUTHOR",
				new BeanPropertyRowMapper<Book>(Book.class));
	}

}
