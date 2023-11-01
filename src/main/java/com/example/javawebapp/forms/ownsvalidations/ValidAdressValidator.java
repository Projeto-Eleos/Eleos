package com.example.javawebapp.forms.ownsvalidations;

import java.util.HashSet;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidAdressValidator implements ConstraintValidator<ValidAdress, String> {

    @Override
    public boolean isValid(String endereco, ConstraintValidatorContext context) {
        if (endereco == null || endereco.length() < 9) {
            return false;
        }

        String[] palavras = endereco.replaceAll(",", " ").split(" ");
        HashSet<String> viasValidas = getViasValidas();

        for (String palavra : palavras) {
            if (viasValidas.contains(palavra.toLowerCase())) {
                return true;
            }
        }

        return false;
    }

    private HashSet<String> getViasValidas() {
        HashSet<String> viasValidas = new HashSet<>();
        viasValidas.add("rua");
        viasValidas.add("avenida");
        viasValidas.add("alameda");
        viasValidas.add("estrada");
        viasValidas.add("praça");
        viasValidas.add("quadra");
        viasValidas.add("travessa");
        viasValidas.add("largo");
        viasValidas.add("rodovia");
        viasValidas.add("viaduto");
        viasValidas.add("passagem");
        viasValidas.add("beco");
        viasValidas.add("boulevard");
        viasValidas.add("via");
        viasValidas.add("ladeira");
        viasValidas.add("travessia");
        return viasValidas;
    }
}
