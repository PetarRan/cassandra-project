package petarran.springframework.services;

import petarran.springframework.commands.ProductForm;
import petarran.springframework.domain_model.Product;

import java.util.List;
import java.util.UUID;

/**
 *
 */
public interface ProductService {

    List<Product> listAll();

    Product getById(Integer id);

    Product saveOrUpdate(Product product);

    void delete(Integer id);

    Product saveOrUpdateProductForm(ProductForm productForm);
}
