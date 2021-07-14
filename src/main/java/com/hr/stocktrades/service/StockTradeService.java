package com.hr.stocktrades.service;

import com.hr.stocktrades.exception.ResourceNotFoundException;
import com.hr.stocktrades.model.StockTrade;

import java.util.List;

public interface StockTradeService {

    StockTrade createTrade(StockTrade stockTrade);

    StockTrade getStockTradeById(Integer id) throws ResourceNotFoundException;

    List<StockTrade> filterStockTrade(String type, Integer userId);
}
