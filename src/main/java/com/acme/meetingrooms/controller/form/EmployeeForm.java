package com.acme.meetingrooms.controller.form;

import javax.validation.constraints.Size;

import com.acme.meetingrooms.validator.constraints.Email;

import lombok.Data;

/**
 * EmployeeForm class representing an employee form.
 * @author Istvan_Hever
 *
 */

@Data
public class EmployeeForm {

    private static final int NAME_MIN_LENGTH = 3;

    private long id;

    @Size(min = NAME_MIN_LENGTH)
    private String name = "";

    @Email
    private String email = "";

}
