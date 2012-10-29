package com.acme.meetingrooms.controller.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;


/**
 * EmployeeForm class representing an employee form.
 * @author Istvan_Hever
 *
 */

public class EmployeeForm {

    private static final int EMAIL_MIN_LENGTH = 5;
    private static final int NAME_MIN_LENGTH = 3;

    @Size(min = NAME_MIN_LENGTH)
    private String name = "";
    @Size(min = EMAIL_MIN_LENGTH)
    @Email
    private String email = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "EmployeeForm [name=" + name + ", email=" + email + "]";
    }

}
