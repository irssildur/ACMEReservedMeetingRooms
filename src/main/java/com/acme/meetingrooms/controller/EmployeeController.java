package com.acme.meetingrooms.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.acme.meetingrooms.controller.form.EmployeeForm;
import com.acme.meetingrooms.service.EmployeeService;
import com.acme.meetingrooms.service.converter.EmployeeConverter;
import com.acme.meetingrooms.service.dto.EmployeeDTO;

/**
 * Controller.
 * @author Istvan_Hever
 *
 */
@Controller
@RequestMapping(value = "/employees/*")
public class EmployeeController {

    private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    private EmployeeService employeeService;
    private EmployeeConverter<EmployeeForm, EmployeeDTO> employeeFormToDTOConverter;

    /**
     * asdf.
     * @param locale asdf
     * @param model asdf
     * @return asdf
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String listEmployees(Locale locale, Model model) {

        logger.debug("employeeService is a class of: " + employeeService.getClass().getName());

        List<EmployeeDTO> employees = employeeService.getAllEmployees();

        for (EmployeeDTO employeeDTO : employees) {
            logger.debug("BeforeemployeeID:" + employeeDTO.getId());
        }

        model.addAttribute("employees", employees);

        for (EmployeeDTO employeeDTO : employees) {
            logger.debug("AfteremployeeID:" + employeeDTO.getId());
        }

        return "employees/list";
    }

    @RequestMapping(value = "add")
    public String addEmployee(Model model, EmployeeForm employeeForm, BindingResult result, RedirectAttributes flash, HttpServletRequest request) {

        logger.debug("employeeFormToDTOConverter is a class of: " + employeeFormToDTOConverter.getClass().getName());

        if (request.getParameter("submit") == null) {
            return "employees/add";
        } else if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "employees/add";
        } else {
            EmployeeDTO employeeDTO = employeeFormToDTOConverter.convert(employeeForm);
            employeeService.addEmployee(employeeDTO);
            flash.addAttribute("msg", "You have succesfully added: " + employeeForm.getName());
            return "redirect:/employees/list";
        }

    }

    @RequestMapping(value = "remove/{id}")
    public String removeEmployee(Model model, HttpServletRequest request, @PathVariable Long id) {

        employeeService.removeEmployee(id);

        return "redirect:/employees/list";
    }

    //    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    //    public String editEmployee(Model model, @PathVariable Long id, HttpServletRequest request) {
    //
    //        EmployeeEntity employeeToShow = employeeService.getEmployeeById(id);
    //        model.addAttribute("employee", employeeToShow);
    //        return "employees/edit";
    //
    //    }
    //
    //    @RequestMapping(value = "edit/{id}", method = RequestMethod.POST)
    //    public String editEmployee(Model model, @PathVariable Long id, HttpServletRequest request, @Valid EmployeeEntity employee) {
    //
    //        employeeService.updateEmployee(employee);
    //
    //        return "redirect:/employees/list";
    //    }

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public EmployeeConverter<EmployeeForm, EmployeeDTO> getEmployeeFormToDTOConverter() {
        return employeeFormToDTOConverter;
    }

    public void setEmployeeFormToDTOConverter(EmployeeConverter<EmployeeForm, EmployeeDTO> employeeFormToDTOConverter) {
        this.employeeFormToDTOConverter = employeeFormToDTOConverter;
    }

}
