package petarran.springframework.services;

import petarran.springframework.domain_model.Product;
import petarran.springframework.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;


    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<Product> listAll() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    @Override
    public List<Product> getByContinent(String continent) {
        return productRepository.findAllByContinent(continent);
    }

    @Override
    public List<Product> getByCountry(String continent, String country) {
        return productRepository.findAllByContinentAndCountry(continent, country);
    }

    @Override
    public List<Product> getByCity(String continent, String country, String city) {
        return productRepository.findAllByContinentAndCountryAndCity(continent, country, city);
    }

    @Override
    public Product getByCode(String continent, String country, String city, String id) {
        UUID uuid = UUID.fromString(id);
        return productRepository.findByCode(continent, country, city, uuid);
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Product product) {
        //productRepository.deleteProduct(product.getContinent(), product.getCountry(),
                //product.getCity(), product.getId());
        productRepository.delete(product);
    }

    @Override
    public void deleteSmart(String continent, String country, String city, String id) {
        UUID uuid = UUID.fromString(id);
        productRepository.deleteSmart(continent, country, city, uuid);

    }

    @Override
    public Product getById(UUID id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product saveOrUpdate(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public void delete(UUID id) {
        productRepository.deleteById(id);

    }

}
