package petarran.springframework.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import petarran.springframework.domain_model.Product;
import petarran.springframework.services.ProductService;

import java.util.Collection;

/**
 *
 */
@RestController
@RequestMapping("/admin-api/listings-api")
public class MyListingsController {
    private final ProductService productService;

    public MyListingsController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping(
            value = "/getAll"
            )
    public Collection<Product> getAll(){
        return null ;//TODO
    }

    @GetMapping(
            value = "/getByContinent/{continent}"
    )
    public Collection<Product> getByContinent(@PathVariable("continent") String continent){
        return productService.getByContinent(continent);//TODO
    }

    @GetMapping(
            value = "/getByContinent/{continent}/{country}"
    )
    public Collection<Product> getByCountry(@PathVariable("continent") String continent,
                                            @PathVariable("country") String country){
        return productService.getByCountry(continent, country);//TODO
    }

    @GetMapping(
            value = "/getByContinent/{continent}/{country}/{city}"
    )
    public Collection<Product> getByContinent(@PathVariable("continent") String continent,
                                              @PathVariable("country") String country,
                                              @PathVariable("city") String city){
        return productService.getByCity(continent, country, city);//TODO
    }


}
