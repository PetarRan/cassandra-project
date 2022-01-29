package petarran.springframework.services;

import petarran.springframework.domain_model.MyListings;

import java.util.List;
import java.util.UUID;

/**
 *
 */
public interface MyListingsService {

    void saveUser(String username);

    List<MyListings> listAll();

    List<MyListings> getByContinent(String continent);
    List<MyListings> getByCountry(String continent, String country);
    List<MyListings> getByCity(String continent, String country, String city);

    void update(MyListings product);
    void save(MyListings product);
    void deleteProduct(MyListings product);

    MyListings getById(UUID id);

    MyListings saveOrUpdate(MyListings product);

    void delete(UUID id);

}
