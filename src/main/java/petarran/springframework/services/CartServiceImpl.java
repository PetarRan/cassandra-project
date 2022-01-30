package petarran.springframework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petarran.springframework.domain_model.Cart;
import petarran.springframework.domain_model.Product;
import petarran.springframework.repositories.CartRepository;
import petarran.springframework.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 */
@Service
public class CartServiceImpl implements CartService {

    ProductRepository productRepository;
    CartRepository cartRepository;


    @Autowired
    public CartServiceImpl(ProductRepository productRepository, CartRepository cartRepository) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
    }


    @Override
    public List<Cart> listAll() {
        return null;
    }

    @Override
    public void save(Cart cart) {
        cartRepository.save(cart);
    }
}
