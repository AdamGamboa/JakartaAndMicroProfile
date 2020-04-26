package com.jakartamp.intro.demo1.resources;

import com.jakartamp.intro.demo1.api.IStockResource;
import com.jakartamp.intro.demo1.model.Stock;
import com.jakartamp.intro.demo1.services.StockService;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 *
 * @author Adam M. Gamboa G
 */
@ApplicationScoped
public class StockResource implements IStockResource{

    @Inject 
    private StockService service;
    
    @Override
    public List<Stock> getAll() {
        return service.getAll();
    }

    @Override
    public List<Stock> getByStatus(String status) {
        return service.getByStatus(status);
    }

    @Override
    public Stock findById(String id) {
        Optional<Stock> stock = service.findById(id);
        if(stock.isPresent()){
            return stock.get();
        }
        throw new WebApplicationException("Stock not found", Response.Status.NOT_FOUND);
    }
    
}
