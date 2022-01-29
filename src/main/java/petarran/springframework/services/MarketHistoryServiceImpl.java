package petarran.springframework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petarran.springframework.domain_model.MarketHistory;
import petarran.springframework.repositories.MarketHistoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 */
@Service
public class MarketHistoryServiceImpl implements MarketHistoryService {

    MarketHistoryRepository marketHistoryRepository;


    @Autowired
    public MarketHistoryServiceImpl(MarketHistoryRepository marketHistoryRepository) {
        this.marketHistoryRepository = marketHistoryRepository;
    }

    @Override
    public List<MarketHistory> listAll() {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
