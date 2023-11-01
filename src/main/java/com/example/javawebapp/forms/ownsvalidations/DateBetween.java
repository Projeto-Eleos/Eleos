package com.example.javawebapp.forms.ownsvalidations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateBetweenValidator.class)
@Documented
public @interface DateBetween {
    String message() default "A data não está dentro do período especificado";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
