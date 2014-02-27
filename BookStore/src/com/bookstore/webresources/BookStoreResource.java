package com.bookstore.webresources;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bookstore.entity.Book;
import com.bookstore.service.AuthorService;
import com.bookstore.service.BookService;
import com.bookstore.service.CategoryService;
import com.bookstore.utils.Types;

@Component
@Path("bookstore")
public class BookStoreResource {
	private static Logger log = Logger.getLogger(BookStoreResource.class);

	@Autowired
	private BookService bookservice;

	@Autowired
	private AuthorService authorservice;

	@Autowired
	private CategoryService categoryservice;

	@SuppressWarnings("incomplete-switch")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{createType}")
	public void create(@PathParam(value = "createType") String createType,
			@Context UriInfo info) {
		log.info("Creating new type :" + createType);
		try {
			switch (Types.CreateType.getValue(createType)) {
			case BOOK:
				getBookservice().createNewBook(info);
				break;
			case AUTHOR:
				getAuthorservice().createNewAuthor(info);
				break;
			case CATEGORY:
				getCategoryservice().createNewCategory(info);
				break;
			}
		} catch (Exception e) {
			throw new WebApplicationException(Status.UNAUTHORIZED);
		}
	}

	@SuppressWarnings("incomplete-switch")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{createType}/{id}")
	public Book getbyId(@PathParam(value = "createType") String createType,
			@PathParam(value = "id") String id) {
		log.info("Getting Details by id type :" + createType);
		try {
			switch (Types.CreateType.getValue(createType)) {
			case BOOK:
				return getBookservice().getById(Integer.parseInt(id));
			case AUTHOR:
				return getAuthorservice().getById(Integer.parseInt(id));
			case CATEGORY:
				return getCategoryservice().getById(Integer.parseInt(id));
			}
		} catch (Exception e) {
			throw new WebApplicationException(Status.UNAUTHORIZED);
		}

		return null;
	}

	@SuppressWarnings("incomplete-switch")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{createType}")
	public List<Book> getAll(@PathParam(value = "createType") String createType) {
		log.info("Getting All of type  :" + createType);
		try {
			switch (Types.CreateType.getValue(createType)) {
			case BOOK:
				return getBookservice().getAllBook();
			case AUTHOR:
				return getAuthorservice().getAllAuthor();
			case CATEGORY:
				return getCategoryservice().getAllCategory();
			}
		} catch (Exception e) {
			throw new WebApplicationException(Status.UNAUTHORIZED);
		}

		return null;
	}

	@SuppressWarnings("incomplete-switch")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{createType}")
	public void update(@PathParam(value = "createType") String createType,
			@Context UriInfo info) {
		log.info("Updating of type :" + createType);
		try {
			switch (Types.CreateType.getValue(createType)) {
			case BOOK:
				getBookservice().updateBook(info);
				break;
			case AUTHOR:
				getAuthorservice().updateAuthor(info);
				break;
			case CATEGORY:
				getCategoryservice().updateCategory(info);
				break;
			}
		} catch (Exception e) {
			throw new WebApplicationException(Status.UNAUTHORIZED);
		}
	}

	@SuppressWarnings("incomplete-switch")
	@DELETE
	@Path("/{createType}/{id}")
	public void delete(@PathParam(value = "createType") String createType,
			@PathParam(value = "id") String id) {
		log.info("Deleting of type :" + createType);
		try {
			switch (Types.CreateType.getValue(createType)) {
			case BOOK:
				getBookservice().deleteBook(Integer.parseInt(id));
				break;
			case AUTHOR:
				getAuthorservice().deleteAuthor(Integer.parseInt(id));
				break;
			case CATEGORY:
				getCategoryservice().deleteCategory(Integer.parseInt(id));
				break;
			}
		} catch (Exception e) {
			throw new WebApplicationException(Status.UNAUTHORIZED);
		}
	}

	public BookService getBookservice() {
		return bookservice;
	}

	public void setBookservice(BookService bookservice) {
		this.bookservice = bookservice;
	}

	public AuthorService getAuthorservice() {
		return authorservice;
	}

	public void setAuthorservice(AuthorService authorservice) {
		this.authorservice = authorservice;
	}

	public CategoryService getCategoryservice() {
		return categoryservice;
	}

	public void setCategoryservice(CategoryService categoryservice) {
		this.categoryservice = categoryservice;
	}

}
