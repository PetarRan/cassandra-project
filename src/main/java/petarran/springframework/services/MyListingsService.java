package petarran.springframework.services;

import org.springframework.data.repository.query.Param;
import petarran.springframework.domain_model.MyListings;
import petarran.springframework.domain_model.Product;

import java.util.List;
import java.util.UUID;

/**
 *
 */
public interface MyListingsService {

    void saveUser(String username);

    List<MyListings> listAll();

    List<MyListings> myListAll(String userId);

    List<MyListings> getByContinent(String userId, String continent);
    List<MyListings> getByCountry(String userId, String continent, String country);
    List<MyListings> getByCity(String userId, String continent, String country, String city);

    void update(MyListings product);
    void save(MyListings product);
    void deleteListing(MyListings product);

    void deleteSmart(String userId, String continent, String country, String city);

    MyListings findByCode(String userId, String continent, String country,
                         String city, String id);

    void updateSmart(Product product, String userId);

    MyListings getById(UUID id);

    MyListings saveOrUpdate(MyListings product);

    void delete(UUID id);

    void saveListing(Product product, String userid);
}
