package petarran.springframework.services;

import petarran.springframework.domain_model.Cart;
import petarran.springframework.domain_model.User;

import java.util.List;

/**
 *
 */
public interface UserService {

    List<Cart> listAll();

    void update(User product);
    void save(User product);
    void deleteProduct(User product);


}
