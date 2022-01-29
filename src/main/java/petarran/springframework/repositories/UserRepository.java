package petarran.springframework.repositories;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import petarran.springframework.domain_model.User;

import java.util.List;
import java.util.UUID;


/**
 *
 */
public interface UserRepository extends CrudRepository<User, UUID> {


}
