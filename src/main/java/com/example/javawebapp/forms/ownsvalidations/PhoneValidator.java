package com.example.javawebapp.forms.ownsvalidations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

    @Override
    public boolean isValid(String telefone, ConstraintValidatorContext context) {
        
        if (!telefone.matches("^\\(\\d{2}\\)\\ \\d+$")) {
            if (!(telefone.matches("[0-9]+") || telefone.length() == 11 || telefone.length() == 10)) {
                return false;
            }
        }
        return true;
    }
}
