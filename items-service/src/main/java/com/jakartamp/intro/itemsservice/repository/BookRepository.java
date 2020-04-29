package com.jakartamp.intro.itemsservice.repository;

import com.jakartamp.intro.itemsservice.model.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Adam M. Gamboa G
 */
@ApplicationScoped
public class BookRepository {
    private List<Book> list;
    private Map<Long, String> bookStockMap;
    
    @PostConstruct
    public void setUp(){
        list = new ArrayList<>();
        list.add(new Book(1, "The Hobbit", "J.R.R Tolkien"));
        list.add(new Book(2, "The Handmaid's Tale", "Margaret Atwood"));
        list.add(new Book(3, "The Man in the High Castle", "Philip K. Dick"));
        
        bookStockMap = new HashMap<>();
        bookStockMap.put(1l, "000001");
        bookStockMap.put(2l, "000002");
        bookStockMap.put(3l, "000003");
    }
    
    public List<Book> getAll(){
        return list;
    }
    
    public Optional<Book> findById(long id){
        return list.stream().filter(b -> b.getId() == id ).findFirst();
    }
    
    public String getStockId(long id){
        return bookStockMap.get(id);
    }
}
