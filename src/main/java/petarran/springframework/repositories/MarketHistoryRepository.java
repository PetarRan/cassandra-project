package petarran.springframework.repositories;

import org.springframework.data.repository.CrudRepository;
import petarran.springframework.domain_model.MarketHistory;


import java.util.UUID;

public interface MarketHistoryRepository extends CrudRepository<MarketHistory, UUID> {
}
