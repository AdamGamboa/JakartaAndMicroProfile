package com.jakartamp.intro.itemsservice.services;

import com.jakartamp.intro.itemsservice.client.StockClient;
import com.jakartamp.intro.itemsservice.model.Stock;
import java.net.URI;
import java.net.URISyntaxException;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

/**
 *
 * @author Adam M. Gamboa G
 */
@RequestScoped
public class StockService {
    
    @Inject @ConfigProperty(name = "stockservice.api.url")
    private String apiUrl;
    
    public Stock getStock(String id){
        URI apiUri = getURI();
        StockClient stockClient = RestClientBuilder.newBuilder()
            .baseUri(apiUri)
            .build(StockClient.class);
        return stockClient.findById(id);
    }
    
    private URI getURI(){
        try {
            return new URI(apiUrl);
        } catch (URISyntaxException ex) {
            throw new RuntimeException("URL not valid:"+apiUrl);
        }
    }
}
