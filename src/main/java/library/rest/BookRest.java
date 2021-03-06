package library.rest;

import java.net.URI;
import java.net.URISyntaxException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;




@Path("/book")
@RequestScoped
public class BookRest {
	
	@Inject
	BookDAO booksService;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBooks() {
		return Response.ok(booksService.listBooks()).build();
	}
	
	
	@POST
	@Path("/new/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createbook(Book book) throws URISyntaxException {
		booksService.createbook(book);
		return Response.created(new URI("localhost:8080/jboss-javaee-webapp/rest/book")).build();
	}
	
	@GET
	@Path("/title/{title}/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchTitle(@PathParam("title") String title) throws URISyntaxException {
		return Response.ok(booksService.searchByTitle(title)).build();
	}
	
	@PUT
	@Path("/updateisbn/{bookId}/{isbn}/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateId(@PathParam("bookId")long bookId, @PathParam("isbn")String isbn) throws URISyntaxException {		
		return Response.ok(booksService.updateById(bookId, isbn)).build();
		
	}
}

	




