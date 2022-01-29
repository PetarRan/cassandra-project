package petarran.springframework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petarran.springframework.domain_model.MyListings;
import petarran.springframework.domain_model.Product;
import petarran.springframework.repositories.MyListingsRepository;
import petarran.springframework.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 */
@Service
public class MyListingServiceImpl implements MyListingsService {

    ProductRepository productRepository;
    MyListingsRepository myListingsRepository;


    @Autowired
    public MyListingServiceImpl(ProductRepository productRepository, MyListingsRepository myListingsRepository) {
        this.productRepository = productRepository;
        this.myListingsRepository = myListingsRepository;
    }


    @Override
    public void saveUser(String username) {

    }

    @Override
    public List<MyListings> listAll() {
        return null;
    }

    @Override
    public List<MyListings> getByContinent(String continent) {
        return null;
    }

    @Override
    public List<MyListings> getByCountry(String continent, String country) {
        return null;
    }

    @Override
    public List<MyListings> getByCity(String continent, String country, String city) {
        return null;
    }

    @Override
    public void update(MyListings product) {

    }

    @Override
    public void save(MyListings product) {

    }

    @Override
    public void deleteProduct(MyListings product) {

    }

    @Override
    public MyListings getById(UUID id) {
        return null;
    }

    @Override
    public MyListings saveOrUpdate(MyListings product) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
