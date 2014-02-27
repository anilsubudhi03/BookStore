package com.bookstore.restFilter;

import javax.ws.rs.ext.Provider;
import org.apache.log4j.Logger;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

@Provider
public class ResourceFilter implements ContainerRequestFilter {

	private static Logger log = Logger.getLogger(ResourceFilter.class);

	@Override
	public ContainerRequest filter(ContainerRequest containerRequest) {
		log.info("Incoming request, filtered by ContainerRequestFilter");
		// GET, POST, PUT, DELETE, ...
		String method = containerRequest.getMethod();
		log.info("Incoming method type :" + method);
		String path = containerRequest.getPath(true);
		log.info("Request URI :" + path);
		
		// Get the authentification passed in HTTP headers parameters
		String auth = containerRequest.getHeaderValue("encKey");
		//If key is valid allows for request processing
		return containerRequest;
	}

}
