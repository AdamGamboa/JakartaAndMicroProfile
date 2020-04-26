package com.jakartamp.intro.demo2.services;

import com.jakartamp.intro.demo2.api.model.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Adam M. Gamboa G
 */
@ApplicationScoped
public class BookService {
    
    private List<Book> list;
    
    @PostConstruct
    public void setUp(){
        list = new ArrayList<>();
        list.add(new Book(1, "The Hobbit", "J.R.R Tolkien"));
        list.add(new Book(2, "The Handmaid's Tale", "Margaret Atwood"));
        list.add(new Book(3, "The Man in the High Castle", "Philip K. Dick"));
    }
    
    public List<Book> getAll(){
        return list;
    }
    
    public Optional<Book> findById(long id){
        return list.stream().filter(b -> b.getId() == id ).findFirst();
    }
    
}
