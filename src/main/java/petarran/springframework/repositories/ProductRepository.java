package petarran.springframework.repositories;

import org.springframework.data.repository.query.Param;
import petarran.springframework.domain_model.Product;
import org.springframework.data.repository.CrudRepository;


/**
 *
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
