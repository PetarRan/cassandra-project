package petarran.springframework.repositories;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import petarran.springframework.domain_model.Cart;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;


/**
 *
 */
public interface CartRepository extends CrudRepository<Cart, UUID> {

    @Query("select * from \"cart\" where \"userid\"= :userId")
    List<Cart> findAllByUserId(@Param("userId") String userId);

    @Query("select * from \"cart\" where \"userid\"= :userId and \"id\"= :id")
    Cart findByUserIdAndId(@Param("userid")String userId, @Param("id")UUID uuid);

    @Query("delete from \"cart\" where \"userid\"= :userid")
    void deleteAllByUser(@Param("userid") String userid);

    @Query("insert into \"cart\"(\"userid\", \"id\", \"description\", \"location\", \"price\" ) values (?0, ?1, ?2, ?3, ?4)")
    void saveCartItem(@Param("userid")String userid, @Param("id")UUID uuid, @Param("description")String description,
                      @Param("location")String location, @Param("price")BigDecimal price);
}
