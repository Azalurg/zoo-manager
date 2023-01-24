package com.github.azalurg.zoomanager.custom;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class Pesez implements ConstraintValidator<PesezType, Long> {

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        char[] digitsChar = Long.toString(value).toCharArray();
        int[] digits = new int[digitsChar.length];
        for (int i = 0; i < digitsChar.length; i++) {
            digits[i] = Character.getNumericValue(digitsChar[i]);
        }

        if (digits.length != 11) {
            return false;
        }

        int sum = 0;

        for (int i = 0; i <= 10; i+= 2) {
            sum += digits[i] * digits[i+1];
        }

        return sum % 10 == digits[10];
    }
}
