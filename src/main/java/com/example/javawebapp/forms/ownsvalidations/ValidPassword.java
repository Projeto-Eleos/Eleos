package com.example.javawebapp.forms.ownsvalidations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidPasswordValidator.class)
@Documented
public @interface ValidPassword {
    String message() default "A senha não atende aos critérios de validação";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
