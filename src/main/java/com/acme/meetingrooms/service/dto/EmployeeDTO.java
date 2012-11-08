package com.acme.meetingrooms.service.dto;

import lombok.Data;


/**
 * Employee class representing an employee.
 * @author Istvan_Hever
 *
 */

@Data
public class EmployeeDTO {

    private long id;
    private String name = "";
    private String email = "";

}
