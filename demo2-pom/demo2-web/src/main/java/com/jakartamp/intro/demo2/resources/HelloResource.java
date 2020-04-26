package com.jakartamp.intro.demo2.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author Huevo
 */
@Path("/hello")
public class HelloResource {
    
    @GET
    public String message(){
        return "Hello World!";
    }
}
