package com.hr.stocktrades.repository;

import com.hr.stocktrades.model.StockTrade;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CustomSpecifications {

    /**
     * Specification  builder to  filter the stock trade based on  optional stockype and Optional userId
     * @param stockType of type String which is an optional field
     * @param userId of type Integer which is an optional field
     * @return Specification with Predicates
     */
    public static Specification<StockTrade> filterStockTrade(Optional<String> stockType, Optional<Integer> userId) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();
            if(stockType.isPresent() && !stockType.get().isEmpty()) {
                predicateList.add(criteriaBuilder.and(criteriaBuilder.equal(criteriaBuilder.lower(root.get("type")), stockType.get().toLowerCase())));
            }
            if(userId.isPresent() && userId.get() != 0) {
                predicateList.add(criteriaBuilder.and(criteriaBuilder.equal(criteriaBuilder.lower(root.get("userId")), userId.get())));
            }
            return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
        });
    }
}
