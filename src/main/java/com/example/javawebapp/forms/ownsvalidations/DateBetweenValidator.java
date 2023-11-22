package com.example.javawebapp.forms.ownsvalidations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateBetweenValidator implements ConstraintValidator<DateBetween, Date> {

    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 124;

    @Override
    public void initialize(DateBetween constraintAnnotation) {
    }

    @Override
    public boolean isValid(Date date, ConstraintValidatorContext context) {
        if (date == null) {
            return true; // A data nula é considerada válida, ajuste conforme necessário
        }

        LocalDate dateLocal = LocalDate.ofInstant(date.toInstant(), ZoneId.systemDefault());
        LocalDate today = LocalDate.now();
        LocalDate minDate = today.minusYears(MAX_AGE);
        LocalDate maxDate = today.minusYears(MIN_AGE);

        return !dateLocal.isBefore(minDate) && !dateLocal.isAfter(maxDate);
    }
}
