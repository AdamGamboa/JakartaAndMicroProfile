package com.jakartamp.intro.demo2.resources.impl;

import com.jakartamp.intro.demo2.api.model.Book;
import com.jakartamp.intro.demo2.api.rest.BookResource;
import com.jakartamp.intro.demo2.services.BookService;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;

/**
 *
 * @author Adam M. Gamboa
 */
@ApplicationScoped
public class BookResourceImpl implements BookResource{

    @Inject 
    private BookService service;
    
    @Override
    public List<Book> getAll() {
        return service.getAll();
    }

    @Override
    public Book findById(Long id) {
        return service.findById(id) 
                .orElseThrow(NotFoundException::new);
    }
    
}
