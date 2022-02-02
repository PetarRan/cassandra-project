package petarran.springframework.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import petarran.springframework.domain_model.Cart;
import petarran.springframework.domain_model.Product;
import petarran.springframework.services.CartService;
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
    private final CartService cartService;

    public ProductController(ProductService productService, MyListingsService myListingsService, CartService cartService){
        this.productService = productService;
        this.myListingsService = myListingsService;
        this.cartService = cartService;
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
            value = "/getByCountry/{continent}/{country}"
    )
    public Collection<Product> getByCountry(@PathVariable("continent") String continent,
                                            @PathVariable("country") String country){
        return productService.getByCountry(continent, country);
    }

    @GetMapping(
            value = "/getByCity/{continent}/{country}/{city}"
    )
    public Collection<Product> getByCity(@PathVariable("continent") String continent,
                                              @PathVariable("country") String country,
                                              @PathVariable("city") String city){
        return productService.getByCity(continent, country, city);
    }

    @GetMapping(
            value = "/getByCode/{continent}/{country}/{city}/{id}"
    )
    public Product getByCode(@PathVariable("continent") String continent,
                                         @PathVariable("country") String country,
                                         @PathVariable("city") String city,
                                         @PathVariable("id") String id){
        return productService.getByCode(continent, country, city, id);
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
    public HttpStatus deleteProduct(@Valid @RequestBody(required = true) Product product, @RequestParam("userid") String userid) {
        try {
            productService.deleteSmart(product.getContinent(), product.getCountry(), product.getCity(),
                    product.getId().toString());
            myListingsService.deleteSmart(userid, product.getContinent(), product.getCountry(), product.getCity());

            //myListingsService.delete(product.getId());
            //productService.delete(product.getId());

        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }

    @PutMapping(
            value = "/updateProduct",
            produces = {"application/json"}
    )
    public HttpStatus updateProduct(@Valid @RequestBody(required = true) Product product, @RequestParam("userid") String userid) {
        try {
            productService.update(product);
            myListingsService.updateSmart(product, userid);
        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }

    @PostMapping(
            value = "/addToCart",
            produces = {"application/json"}
    )
    public HttpStatus addToCart(@Valid @RequestBody(required = true) Cart cart) {
        try {
            cartService.addToCart(cart);
        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }

    @GetMapping(
            value = "/getMyCart/{userid}"
    )
    public Collection<Cart> getMyCart(@PathVariable("userid") String userid){
        return cartService.findByUserId(userid);
    }

    @DeleteMapping(
            value = "/deleteCart/{userid}",
            produces = {"application/json"}
    )
    public HttpStatus clearCart(@PathVariable("userid") String userid) {
        try {
            cartService.deleteAll(userid);

        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }

    @DeleteMapping(
            value = "/deleteFromCatalog",
            produces = {"application/json"}
    )
    public HttpStatus deleteFromCatalog(@Valid @RequestBody(required = true) Product product) {
        try {
            productService.deleteSmart(product.getContinent(), product.getCountry(), product.getCity(),
                    product.getId().toString());
        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }

}
