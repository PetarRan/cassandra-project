package petarran.springframework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petarran.springframework.domain_model.Cart;
import petarran.springframework.domain_model.User;
import petarran.springframework.repositories.CartRepository;
import petarran.springframework.repositories.ProductRepository;

import java.util.List;

/**
 *
 */
@Service
public class UserServiceImpl implements UserService {

    ProductRepository productRepository;
    CartRepository cartRepository;


    @Autowired
    public UserServiceImpl(ProductRepository productRepository, CartRepository cartRepository) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
    }


    @Override
    public List<Cart> listAll() {
        return null;
    }

    @Override
    public void update(User product) {

    }

    @Override
    public void save(User product) {

    }

    @Override
    public void deleteProduct(User product) {

    }
}
