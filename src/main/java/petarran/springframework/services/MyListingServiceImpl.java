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
    public List<MyListings> myListAll(String userId) {
        return myListingsRepository.findMyListing(userId);
    }

    @Override
    public List<MyListings> getByContinent(String userId, String continent) {
        return myListingsRepository.findAllByContinent(userId, continent);
    }

    @Override
    public List<MyListings> getByCountry(String userId, String continent, String country) {
        return myListingsRepository.findAllByContinentAndCountry(userId, continent, country);
    }

    @Override
    public List<MyListings> getByCity(String userId, String continent, String country, String city) {
        return myListingsRepository.findAllByContinentAndCountryAndCity(userId, continent, country, city);
    }

    @Override
    public void update(MyListings product) {
        myListingsRepository.save(product);
    }

    @Override
    public void save(MyListings product) {
        myListingsRepository.save(product);
    }

    @Override
    public void deleteProduct(MyListings product) {
        myListingsRepository.delete(product);
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

    @Override
    public void saveListing(Product product, String userid) {
        MyListings myListings = new MyListings();

        myListings.setCity(product.getCity());
        myListings.setContinent(product.getContinent());
        myListings.setCountry(product.getCountry());
        myListings.setDescription(product.getDescription());
        myListings.setImageUrl(product.getImageUrl());
        myListings.setUserId(userid);
        myListingsRepository.save(myListings);

    }
}
