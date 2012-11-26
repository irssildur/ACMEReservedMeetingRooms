package com.acme.meetingrooms.service.dto;

import java.util.List;

import lombok.Data;

/**
 * Class representing an object that should be returned for an Ajax listEmployees request.
 * @author Istvan_Hever
 *
 */
@Data
public class EmployeeListAjaxDTO {

    private Long numberOfEmployees;
    private List<EmployeeDTO> employees;
}
