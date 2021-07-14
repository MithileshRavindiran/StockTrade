package com.hr.stocktrades.service.impl;

import com.hr.stocktrades.exception.ResourceNotFoundException;
import com.hr.stocktrades.model.StockTrade;
import com.hr.stocktrades.repository.CustomSpecifications;
import com.hr.stocktrades.repository.StockTradeRepository;
import com.hr.stocktrades.service.StockTradeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class StockTradeServiceImpl implements StockTradeService {

    private final StockTradeRepository stockTradeRepository;



    @Override
    public StockTrade createTrade(StockTrade stockTrade) {
        return stockTradeRepository.save(stockTrade);
    }

    @Override
    public StockTrade getStockTradeById(Integer id) throws ResourceNotFoundException {
        Optional<StockTrade> stockTradeOptional = stockTradeRepository.findById(id);
        if (! stockTradeOptional.isPresent()) {
            throw new ResourceNotFoundException("Requested Stock Trade record is not found");
        }
        return stockTradeOptional.get();
    }

    @Override
    public List<StockTrade> filterStockTrade(String type, Integer userId) {
        return stockTradeRepository.findAll(CustomSpecifications
                .filterStockTrade(Optional.ofNullable(type), Optional.ofNullable(userId)), Sort.by(Sort.Direction.ASC, "id"));
    }


}
