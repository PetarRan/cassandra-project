package petarran.springframework.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import petarran.springframework.domain_model.Product;
import petarran.springframework.services.CartService;
import petarran.springframework.services.MyListingsService;
import petarran.springframework.services.ProductService;

import java.util.Collection;

/**
 *
 */
@RestController
@RequestMapping("/admin-api/cart-api")
public class CartController {
    private final ProductService productService;
    private final CartService cartService;
    private final MyListingsService myListingsService;

    public CartController(ProductService productService, CartService cartService, MyListingsService myListingsService ){
        this.productService = productService;
        this.cartService = cartService;
        this.myListingsService = myListingsService;
    }

    @GetMapping(
            value = "/getAll"
            )
    public Collection<Product> getAll(){
        return null; //TODO
    }


}
