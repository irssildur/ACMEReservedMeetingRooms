package com.acme.meetingrooms.controller;

import lombok.Data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.acme.meetingrooms.service.AjaxEmployeeService;
import com.acme.meetingrooms.service.dto.EmployeeListAjaxDTO;

/**
 * asdf.
 * @author Istvan_Hever
 *
 */
@Data
@Controller
@RequestMapping(value = "/employees")
public class EmployeeAjaxController {

    private Logger logger = LoggerFactory.getLogger(EmployeeAjaxController.class);
    private AjaxEmployeeService ajaxEmployeeService;

    @RequestMapping(value = "/listajax", method = RequestMethod.GET)
    public @ResponseBody
    EmployeeListAjaxDTO listEmployeesAjax(String from, String step) {
        logger.debug("listEmployeesAjax from: " + " " + from + " step: " + step);

        EmployeeListAjaxDTO listAjaxDTO = new EmployeeListAjaxDTO();

        if (from != null && step != null) {
            Long fromArg = Long.parseLong(from);
            Long stepArg = Long.parseLong(step);
            listAjaxDTO = ajaxEmployeeService.listEmployees(fromArg, stepArg);
        } else {
            listAjaxDTO = ajaxEmployeeService.listEmployees();
        }

        logger.debug(listAjaxDTO.getNumberOfEmployees().toString());
        return listAjaxDTO;
    }

}
