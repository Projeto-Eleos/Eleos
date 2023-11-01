package com.example.javawebapp.forms.ownsvalidations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Calendar;
import java.util.Date;

public class DateBetweenValidator implements ConstraintValidator<DateBetween, Date> {

    @Override
    public boolean isValid(Date date, ConstraintValidatorContext context) {
        Calendar today = Calendar.getInstance();
        Calendar max = Calendar.getInstance();
        Calendar min = Calendar.getInstance();

        today.setTime(new Date());
        max.set(today.get(Calendar.YEAR) - 124, today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH));
        min.set(today.get(Calendar.YEAR) - 18, today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH));

        Calendar dateCalendar = Calendar.getInstance();
        dateCalendar.setTime(date);

        if (dateCalendar.after(max) || dateCalendar.before(min)) {
            return false;
        }
        return true;
    }
}
