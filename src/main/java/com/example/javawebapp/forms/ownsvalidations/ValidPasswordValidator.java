package com.example.javawebapp.forms.ownsvalidations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidPasswordValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public void initialize(ValidPassword constraint) {
    }

    @Override
    public boolean isValid(String senha, ConstraintValidatorContext context) {
        if (senha == null) {
            return false;
        }

        // Verifique o comprimento da senha
        if (senha.length() < 8 || senha.length() > 16) {
            return false;
        }

        // Verifique se há pelo menos uma letra maiúscula
        if (!senha.matches(".*[A-Z].*")) {
            return false;
        }

        // Verifique se há pelo menos uma letra minúscula
        if (!senha.matches(".*[a-z].*")) {
            return false;
        }

        // Verifique se há pelo menos um caractere especial (você pode personalizar essa verificação)
        if (!senha.matches(".*[!@#$%^&*()].*")) {
            return false;
        }

        return true;
    }
}
