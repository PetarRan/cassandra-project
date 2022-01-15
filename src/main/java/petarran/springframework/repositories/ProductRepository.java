package petarran.springframework.repositories;

import org.springframework.data.repository.query.Param;
import petarran.springframework.domain_model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

/**
 *
 */
public interface ProductRepository extends CrudRepository<Product, UUID> {
}
