package petarran.springframework.repositories;

import org.springframework.data.repository.query.Param;
import petarran.springframework.domain_model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

/**
 * Created by jt on 1/10/17.
 */
public interface ProductRepository extends CrudRepository<Product, UUID> {
}
