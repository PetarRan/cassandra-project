package petarran.springframework.repositories;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import petarran.springframework.domain_model.MyListings;
import petarran.springframework.domain_model.Product;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;


/**
 *
 */
public interface ProductRepository extends CrudRepository<Product, UUID> {
    @Query("select * from \"products\" where \"continent\"= :continent")
    List<Product> findAllByContinent(@Param("continent") String continent);

    @Query("select * from \"products\" where \"continent\"= :continent and \"country\"= :country")
    List<Product> findAllByContinentAndCountry(@Param("continent")String continent, @Param("country")String country);

    @Query("select * from \"products\" where \"continent\"= :continent and \"country\"= :country and \"city\"= :city")
    List<Product> findAllByContinentAndCountryAndCity(@Param("continent")String continent,
                                                      @Param("country")String country, @Param("city")String city);


    @Query("delete from \"products\" where \"continent\"= :continent and \"country\"= :country and \"city\"= :city and \"id\"= :id")
    void deleteSmart(@Param("continent")String continent,
                     @Param("country")String country, @Param("city")String city,
                     @Param("id")UUID id);

    @Query("select * from \"products\" where \"continent\"= :continent and \"country\"= :country and \"city\"= :city and \"id\"= :id")
    Product findByCode(@Param("continent")String continent,
                          @Param("country")String country,
                          @Param("city")String city, @Param("id")UUID id);
}
