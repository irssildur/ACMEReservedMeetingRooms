package com.acme.meetingrooms.service;

import com.acme.meetingrooms.service.dto.EmployeeListAjaxDTO;

/**
 * asdf.
 * @author Istvan_Hever
 *
 */
public interface AjaxEmployeeService {

    /**
     * asdf.
     * @return asdf
     */
    EmployeeListAjaxDTO listEmployees();

    /**
     * asdf.
     * @param from s
     * @param step s
     * @return s
     */
    EmployeeListAjaxDTO listEmployees(Long from, Long step);

}