package com.acme.meetingrooms.validator.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Email validator annotation.
 * @author Istvan_Hever
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailConstrantValidator.class)
public @interface Email {

    /**
     * asdf.
     * @return
     */
    String message() default "E-mail format doens't valid";

    /**
     * asdf.
     * @return
     */
    Class<?>[] groups() default {};

    /**
     * asdf.
     * @return
     */
    Class<? extends Payload>[] payload() default {};

}
