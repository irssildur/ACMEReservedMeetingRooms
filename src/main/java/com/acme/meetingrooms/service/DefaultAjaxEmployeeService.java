package com.acme.meetingrooms.service;

import java.util.List;

import lombok.Data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.acme.meetingrooms.service.dto.EmployeeDTO;
import com.acme.meetingrooms.service.dto.EmployeeListAjaxDTO;

/**
 * asdf.
 * @author Istvan_Hever
 *
 */
@Data
public class DefaultAjaxEmployeeService implements AjaxEmployeeService {

    private Logger logger = LoggerFactory.getLogger(DefaultAjaxEmployeeService.class);
    private EmployeeService employeeService;

    @Override
    public EmployeeListAjaxDTO listEmployees() {
        logger.debug("listEmployees()");

        EmployeeListAjaxDTO listAjaxDTO = new EmployeeListAjaxDTO();

        listAjaxDTO.setNumberOfEmployees(employeeService.countEmployees());
        listAjaxDTO.setEmployees(employeeService.getAllEmployees());

        return listAjaxDTO;
    }

    @Override
    public EmployeeListAjaxDTO listEmployees(Long from, Long step) {
        if (from < 0 && step < 0) {
            throw new IndexOutOfBoundsException();
        }
        EmployeeListAjaxDTO listAjaxDTO = new EmployeeListAjaxDTO();

        List<EmployeeDTO> employees = employeeService.getEmployees(from, step);

        listAjaxDTO.setNumberOfEmployees(employeeService.countEmployees());
        listAjaxDTO.setEmployees(employees);

        return listAjaxDTO;
    }
}
