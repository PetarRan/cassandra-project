package petarran.springframework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import petarran.springframework.services.MarketHistoryService;

@Controller
public class MarketHistoryController {
    private MarketHistoryService marketHistoryService;

    @Autowired
    public void setMarketHistoryService(MarketHistoryService marketHistoryService) {
        this.marketHistoryService = marketHistoryService;
    }

}
