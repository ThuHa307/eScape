package com.example.eScape.validation.custome;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = SizeValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidSize {
    String message() default "Size must be one of XS, S, M, L, XL, XXL";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
