package com.hr.stocktrades.model;


import com.hr.stocktrades.service.validator.StockType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Stock Trade domain class
 */
@Entity
@Table(name ="stock_trade")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockTrade {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotEmpty(message = "Stock type is mandatory")
    @StockType(message ="Not a valid stock type")
    private String type;

    @Column
    private Integer userId;

    @Column
    private String symbol;

    @Column
    @NotNull(message = "Share should  not be null")
    @Min(value = 1, message = "Share should not be lesser that 1")
    @Max(value = 100, message = "Share  should not be greater than 100")
    private Integer shares;

    @Column
    private Integer price;

    @Column
    private Long timestamp;

    public StockTrade(String type, Integer  userId, String symbol,  Integer shares, Integer price,  Long timestamp) {
        this.type = type;
        this.userId = userId;
        this.symbol = symbol;
        this.shares = shares;
        this.price = price;
        this.timestamp = timestamp;
    }
}
