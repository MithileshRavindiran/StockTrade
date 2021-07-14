package com.hr.stocktrades.controller;

import com.hr.stocktrades.exception.ResourceNotFoundException;
import com.hr.stocktrades.model.StockTrade;
import com.hr.stocktrades.service.StockTradeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/trades")
@RequiredArgsConstructor
@Slf4j
public class StockTradeRestController {

    private final StockTradeService stockTradeService;

    /**
     * Method to  create new stock trade records
     * @param stockTrade of type {@link StockTrade}
     * @return ResponseEntity with created Stock Trade record , when  validation fails exception will the thrown  from handler
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockTrade> createNewTrade(@RequestBody @Valid StockTrade stockTrade) {
        return new ResponseEntity<>(stockTradeService.createTrade(stockTrade), HttpStatus.CREATED);
    }


    /**
     * Method to filter trades on optional stockType  and userId. If optional parameter doesn't exists then it will return all records sorted by  Id
     * @param type is the stock type on which search  needs to be done
     * @param userId is the  userId on  which search  will be done
     * @return ResponseEntity with list of matching Stock Trade record
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockTrade>> getStockTrades(@RequestParam(required = false)  String type, @RequestParam(required = false) Integer userId) {
        return new ResponseEntity<>(stockTradeService.filterStockTrade(type, userId), HttpStatus.OK);
    }


    /**
     * Method to retrieve the StockTrade by Id, if no  record match return Not Found Exception
     * @param id of type id
     * @return Response Entity with matched Stock Records
     * @throws ResourceNotFoundException
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockTrade> getStockTradeById(@PathVariable(name = "id") Integer id) throws ResourceNotFoundException {
        return new ResponseEntity<>(stockTradeService.getStockTradeById(id), HttpStatus.OK);
    }







}