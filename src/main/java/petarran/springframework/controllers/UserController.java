package petarran.springframework.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import petarran.springframework.domain_model.User;
import petarran.springframework.services.CartService;
import petarran.springframework.services.MyListingsService;
import petarran.springframework.services.ProductService;

import java.util.Collection;

/**
 *
 */
@RestController
@RequestMapping("/admin-api/user-api")
public class UserController {
    private final ProductService productService;
    private final CartService cartService;
    private final MyListingsService myListingsService;

    public UserController(ProductService productService, CartService cartService, MyListingsService myListingsService ){
        this.productService = productService;
        this.cartService = cartService;
        this.myListingsService = myListingsService;
    }

    @GetMapping(
            value = "/getAll"
            )
    public Collection<User> getAll(){
        return null; //TODO
    }


}
