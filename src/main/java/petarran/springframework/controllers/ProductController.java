package petarran.springframework.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import petarran.springframework.domain_model.Product;
import petarran.springframework.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.Collection;
import java.util.UUID;

/**
 *
 */
@RestController
@RequestMapping("/admin-api/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping(
            value = "/getAll"
            )
    public Collection<Product> getAll(){
        return productService.listAll();
    }

    @GetMapping(
            value = "/getByContinent/{continent}"
    )
    public Collection<Product> getByContinent(@PathVariable("continent") String continent){
        return productService.getByContinent(continent);
    }

    @GetMapping(
            value = "/getByContinent/{continent}/{country}"
    )
    public Collection<Product> getByCountry(@PathVariable("continent") String continent,
                                            @PathVariable("country") String country){
        return productService.getByCountry(continent, country);
    }

    @GetMapping(
            value = "/getByContinent/{continent}/{country}/{city}"
    )
    public Collection<Product> getByContinent(@PathVariable("continent") String continent,
                                              @PathVariable("country") String country,
                                              @PathVariable("city") String city){
        return productService.getByCity(continent, country, city);
    }

    @PostMapping(
            value = "/addProduct",
            produces = {"application/json"}
    )
    public HttpStatus addProduct(@RequestBody(required = true) Product product) {
        try {
            productService.save(product);
        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }

    @DeleteMapping(
            value = "/deleteProduct",
            produces = {"application/json"}
    )
    public HttpStatus deleteProduct(@RequestBody(required = true) Product product) {
        try {
            productService.deleteProduct(product);
        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }

    @PutMapping(
            value = "/updateProduct",
            produces = {"application/json"}
    )
    public HttpStatus updateProduct(@RequestBody(required = true) Product product) {
        try {
            productService.update(product);
        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }

}
