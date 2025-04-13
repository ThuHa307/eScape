package com.example.eScape.validation.custome;

import com.example.eScape.common.SizeEnum;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class SizeValidator implements ConstraintValidator<ValidSize, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) {
            return true;
        }
        return Arrays.stream(SizeEnum.values())
                .anyMatch(size -> size.name().equals(value));
    }
}