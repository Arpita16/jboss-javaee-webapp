package library.rest;


import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/loan")
@RequestScoped
public class LoanRest {
	

	    @Inject
		LoanDAO loanService;
		
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Response getLoan() {
			return Response.ok(loanService.listLoans()).build();
		}
		
		@POST
		@Path("/{bookId}/{memberId}/")
		@Consumes(MediaType.APPLICATION_JSON)
		public Response CreateLoan(@PathParam("bookId")  Long bookId, @PathParam("memberId") Long memberId) throws URISyntaxException {
			loanService.Createloan(bookId,memberId);
			return Response.created(new URI("localhost:8080/jboss-javaee-webapp/rest/loan/"+bookId+memberId)).build();
		}
		
		@GET
		@Path("/{loanId}/")
		@Produces(MediaType.APPLICATION_JSON)
		public Response searchLoanId(@PathParam("loanId") int loanId) throws URISyntaxException {
			return Response.ok(loanService.findById(loanId)).build();
		}
		
		@PUT
		@Path("/updatestartdate/{loanId}/{newstartdate}/")
		@Produces(MediaType.APPLICATION_JSON)
		public Response updateById(@PathParam("loanId")int loanId,LocalDate newstartdate) throws URISyntaxException {
			 Loan loan =loanService.updateById(loanId,newstartdate);
			 return Response.created(new URI("localhost:8080/jboss-javaee-webapp/rest/loan/"+loanId)).build();
			
		}
		
		
	
	
	
	
	

}
