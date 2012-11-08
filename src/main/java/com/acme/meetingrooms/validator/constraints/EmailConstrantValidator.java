package com.acme.meetingrooms.validator.constraints;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;




/**
 * Constraint validator for Email.
 * @author Istvan_Hever
 *
 */
public class EmailConstrantValidator implements ConstraintValidator<Email, String> {

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private Pattern pattern;
    private Matcher matcher;

    @Override
    public void initialize(Email constraintAnnotation) {
        pattern = Pattern.compile(EMAIL_PATTERN);

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        Boolean valid = true;

        if (value == null) {
            valid = false;
        } else {
            matcher = pattern.matcher(value);
            valid = matcher.matches();
        }
        return valid;
    }
}
