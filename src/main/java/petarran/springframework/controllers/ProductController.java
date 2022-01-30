package petarran.springframework.controllers;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import petarran.springframework.domain_model.Product;
import petarran.springframework.services.MyListingsService;
import petarran.springframework.services.ProductService;

import javax.validation.Valid;
import java.util.Collection;

/**
 *
 */
@RestController
@RequestMapping("/admin-api/product")
public class ProductController {
    private final ProductService productService;
    private final MyListingsService myListingsService;

    public ProductController(ProductService productService, MyListingsService myListingsService){
        this.productService = productService;
        this.myListingsService = myListingsService;
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
    public HttpStatus addProduct(@Valid @RequestBody(required = true) Product product, @RequestParam("userid") String userid) {
        try {
            productService.save(product);
            myListingsService.saveListing(product, userid);
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
