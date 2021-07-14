package com.hr.stocktrades.repository;

import com.hr.stocktrades.model.StockTrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;


@Repository
@Transactional(rollbackFor= SQLException.class)
public interface StockTradeRepository extends JpaRepository<StockTrade, Integer>, JpaSpecificationExecutor {

}
