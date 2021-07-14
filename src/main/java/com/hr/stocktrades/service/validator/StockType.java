package com.hr.stocktrades.service.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {StockTypeValidator.class})
public @interface StockType {

    String message() default "Invalid StockType";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload()  default {};

}
