package petarran.springframework.repositories;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import petarran.springframework.domain_model.MyListings;

import java.util.List;
import java.util.UUID;


/**
 *
 */
public interface MyListingsRepository extends CrudRepository<MyListings, UUID> {
    @Query("select * from \"products\" where \"continent\"= :continent")
    List<MyListings> findAllByContinent(@Param("continent") String continent);

    @Query("select * from \"products\" where \"continent\"= :continent and \"country\"= :country")
    List<MyListings> findAllByContinentAndCountry(@Param("continent")String continent, @Param("country")String country);

    @Query("select * from \"products\" where \"continent\"= :continent and \"country\"= :country and \"city\"= :city")
    List<MyListings> findAllByContinentAndCountryAndCity(@Param("continent")String continent,
                                                      @Param("country")String country, @Param("city")String city);


}
