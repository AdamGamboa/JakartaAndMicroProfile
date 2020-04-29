package com.jakartamp.intro.itemsservice.repository;

import com.jakartamp.intro.itemsservice.model.Book;
import com.jakartamp.intro.itemsservice.model.Groceries;
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
public class GroceriesRepository {
    private List<Groceries> list;
    private Map<Long, String> groceriesStockMap;
    
    @PostConstruct
    public void setUp(){
        list = new ArrayList<>();
        list.add(new Groceries(1, "Beans", "Great Value"));
        list.add(new Groceries(2, "Milk", "Muuu"));
        list.add(new Groceries(3, "Butter", "Clover"));
        
        groceriesStockMap = new HashMap<>();
        groceriesStockMap.put(1l, "000004");
        groceriesStockMap.put(2l, "000005");
        groceriesStockMap.put(3l, "000006");
    }
    
    public List<Groceries> getAll(){
        return list;
    }
    
    public Optional<Groceries> findById(long id){
        return list.stream().filter(g -> g.getId() == id ).findFirst();
    }
    
    public String getStockId(long id){
        return groceriesStockMap.get(id);
    }
}
