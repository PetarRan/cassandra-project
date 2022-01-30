package petarran.springframework.services;

import petarran.springframework.domain_model.Cart;

import java.util.List;
import java.util.UUID;

/**
 *
 */
public interface CartService {

    List<Cart> listAll();

    void save(Cart cart);



}
