package com.jakartamp.intro.demo2.api.rest;


import com.jakartamp.intro.demo2.api.model.Book;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Adam M. Gamboa G
 */
@Path("/books")
public interface BookResource {
    
    @GET 
    @Produces(MediaType.APPLICATION_JSON)        
    List<Book> getAll();
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Book findById(@PathParam("id") Long id);
}
