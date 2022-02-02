package petarran.springframework.services;

import petarran.springframework.domain_model.Cart;
import petarran.springframework.domain_model.Product;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 *
 */
public interface CartService {

    List<Cart> listAll();

    void save(Cart cart);


    Collection<Cart> findByUserId(String userid);

    void delete(Cart cart);

    void deleteAll(String userid);

    void addToCart(Cart cart);
}
