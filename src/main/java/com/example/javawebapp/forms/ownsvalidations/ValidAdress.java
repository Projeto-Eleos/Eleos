package com.example.javawebapp.forms.ownsvalidations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidAdressValidator.class)
@Documented
public @interface ValidAdress {
    String message() default "O endereço é inválido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
