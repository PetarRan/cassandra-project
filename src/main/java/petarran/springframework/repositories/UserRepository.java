package petarran.springframework.repositories;

import org.springframework.data.repository.CrudRepository;
import petarran.springframework.domain_model.User;

import java.util.UUID;


/**
 *
 */
public interface UserRepository extends CrudRepository<User, UUID> {

}
