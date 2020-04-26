
package com.jakartamp.intro.demo1.services;

import com.jakartamp.intro.demo1.model.Stock;
import com.jakartamp.intro.demo1.repository.StockRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;

/**
 *
 * @author Adam M. Gamboa G
 */
@ApplicationScoped
public class StockService {
    
    @Inject
    private StockRepository repository;
    
    @Counted
    public List<Stock> getAll(){
        return repository.getData();
    }
    
    
    @Timed
    public List<Stock> getByStatus(String status){
        return repository.getData().stream()
                .filter(s -> s.getStatus().equals(status))
                .collect(Collectors.toList());
    }
    
    public Optional<Stock> findById(String id){
        return repository.getData().stream()
                .filter(s ->  s.getId().equals(id))
                .findFirst();
    }
}
