package com.github.azalurg.zoomanager.custom;

import java.lang.annotation.Documented;
import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = Pesez.class)
@Documented
public @interface PesezType {
    String message() default "Pesez is not valid";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
