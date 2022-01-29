package petarran.springframework.services;

import petarran.springframework.domain_model.MarketHistory;

import java.util.List;
import java.util.UUID;

public interface MarketHistoryService {
    List<MarketHistory> listAll();

    void delete(UUID id);
}
