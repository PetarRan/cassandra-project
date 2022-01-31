package petarran.springframework.services;

import petarran.springframework.domain_model.Product;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 *
 */
public interface ProductService {

    List<Product> listAll();

    List<Product> getByContinent(String continent);
    List<Product> getByCountry(String continent, String country);
    List<Product> getByCity(String continent, String country, String city);

    void update(Product product);
    void save(Product product);
    void deleteProduct(Product product);

    void deleteSmart(String continent, String country, String city, String id);

    Product getByCode(String continent, String country, String city, String id);

    Product getById(UUID id);

    Product saveOrUpdate(Product product);

    void delete(UUID id);
}
