package com.hr.stocktrades.service.validator;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;


@Component
public class StockTypeValidator implements ConstraintValidator<StockType, String> {
    protected  String stockType;

    public static final List<String> validStockTypes = Arrays.asList("buy", "sell");
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (!validStockTypes.contains(value)) {
            return false;
        }
        return true;
    }
}
