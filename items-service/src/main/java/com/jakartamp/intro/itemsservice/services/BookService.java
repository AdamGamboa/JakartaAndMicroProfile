package com.jakartamp.intro.itemsservice.services;


import com.jakartamp.intro.itemsservice.model.Book;
import com.jakartamp.intro.itemsservice.model.Stock;
import com.jakartamp.intro.itemsservice.repository.BookRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 *
 * @author Adam M. Gamboa G
 */
@ApplicationScoped
public class BookService {
    
    @Inject 
    private BookRepository repository;
    
    @Inject 
    private StockService stockService;
    
    public List<Book> getAll(){
        return repository.getAll().stream()
                .map(b -> { 
                    String stockId = repository.getStockId(b.getId());
                    Stock stock = stockService.getStock(stockId);
                    b.setStock(stock);
                    return b;})
                .collect(Collectors.toList());
    }
    
    public Optional<Book> findById(long id){
        Optional<Book> book = repository.findById(id);
        if(book.isPresent()){
            Book b = book.get();
            String stockId = repository.getStockId(b.getId());
            Stock stock = stockService.getStock(stockId);
            b.setStock(stock);
        }
        return book;
    } 
   
    
}
