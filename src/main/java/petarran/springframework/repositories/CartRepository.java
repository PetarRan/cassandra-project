package petarran.springframework.repositories;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import petarran.springframework.domain_model.Cart;

import java.util.List;
import java.util.UUID;


/**
 *
 */
public interface CartRepository extends CrudRepository<Cart, UUID> {

    @Query("select * from \"cart\" where \"userid\"= :userId")
    List<Cart> findAllByUserId(@Param("userId") String userId);


}
