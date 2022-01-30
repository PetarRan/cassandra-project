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

    @Query("select * from \"listings\" where \"userid\"= :userid")
    List<MyListings> findMyListing(@Param("userid") String userId);

    @Query("select * from \"listings\" where \"userid\"= :userid  and \"continent\"= :continent")
    List<MyListings> findAllByContinent(@Param("userid") String userId, @Param("continent") String continent);

    @Query("select * from \"listings\" where \"userid\"=:userid  and \"continent\"= :continent and \"country\"= :country")
    List<MyListings> findAllByContinentAndCountry(@Param("userid") String userId,
                                                  @Param("continent")String continent, @Param("country")String country);

    @Query("select * from \"listings\" where \"userid\"=:userid  and \"continent\"= :continent and \"country\"= :country and \"city\"= :city")
    List<MyListings> findAllByContinentAndCountryAndCity(@Param("userid") String userId,
                                                         @Param("continent")String continent,
                                                         @Param("country")String country,
                                                         @Param("city")String city);


}
