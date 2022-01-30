package petarran.springframework.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import petarran.springframework.domain_model.Cart;
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

    public CartController(ProductService productService, CartService cartService){
        this.productService = productService;
        this.cartService = cartService;
    }

    @GetMapping(
            value = "/getAll"
            )
    public Collection<Cart> getAll(){
        return cartService.listAll();
    }

    @PostMapping(
            value = "/addCartProduct",
            produces = {"application/json"}
    )
    public HttpStatus addProduct(@RequestBody(required = true) Cart cart) {
        try {
            cartService.save(cart);
        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }

}
