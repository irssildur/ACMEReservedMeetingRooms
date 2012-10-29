package com.acme.meetingrooms.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.acme.meetingrooms.controller.form.EmployeeForm;
import com.acme.meetingrooms.service.EmployeeNotFoundException;
import com.acme.meetingrooms.service.EmployeeService;
import com.acme.meetingrooms.service.builder.EmployeeBuilder;
import com.acme.meetingrooms.service.dto.EmployeeDTO;

/**
 * Controller.
 * @author Istvan_Hever
 *
 */
@Controller
@RequestMapping(value = "/employees")
public class EmployeeController {

    private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    private EmployeeService employeeService;
    private Converter<EmployeeForm, EmployeeDTO> employeeFormToDTOConverter;

    private EmployeeBuilder<EmployeeDTO> dtoBuilder;

    /**
     * asdf.
     * @param locale asdf
     * @param model asdf
     * @return asdf
     */

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listEmployees(Model model) {

        List<EmployeeDTO> employees = employeeService.getAllEmployees();

        model.addAttribute("employees", employees);

        return "employees/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addEmployee(Model model, HttpServletRequest request) {

        //logger.debug("employeeFormToDTOConverter is a class of: " + employeeFormToDTOConverter.getClass().getName());
        model.addAttribute("employeeForm", new EmployeeForm());
        return "employees/add";

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveEmployee(Model model, @Valid EmployeeForm employeeForm, BindingResult result, RedirectAttributes flash, HttpServletRequest request) {

        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            logger.debug(result.getAllErrors().toString());
            return "employees/add";
        } else {
            EmployeeDTO employeeDTO = employeeFormToDTOConverter.convert(employeeForm);
            employeeService.addEmployee(employeeDTO);
            flash.addAttribute("msg", "You have succesfully added: " + employeeForm.getName());
            return "redirect:/employees/list";
        }

    }

    @RequestMapping(value = "/remove")
    public String removeEmployee(@RequestParam(value = "id") String id, Model model, HttpServletRequest request) {

        logger.debug(id);
        Long removeId = Long.parseLong(id);
        employeeService.removeEmployee(removeId);

        //return "redirect:/employees/list";
        return listEmployees(model);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editEmployee(@RequestParam(value = "id") String id, Model model, HttpServletRequest request) throws EmployeeNotFoundException {

        Long editId = Long.parseLong(id);

        EmployeeDTO employeeToShow;

        employeeToShow = employeeService.getEmployeeById(editId);

        model.addAttribute("employee", employeeToShow);
        return "employees/edit";

    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editEmployee(Model model, HttpServletRequest request, EmployeeDTO employee) {
        //EmployeeDTO toUpdate = employeeFormToDTOConverter.convert(employee);
        //employeeService.updateEmployee(toUpdate);
        employeeService.updateEmployee(employee);

        return "redirect:/employees/list";
    }

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Converter<EmployeeForm, EmployeeDTO> getEmployeeFormToDTOConverter() {
        return employeeFormToDTOConverter;
    }

    public void setEmployeeFormToDTOConverter(Converter<EmployeeForm, EmployeeDTO> employeeFormToDTOConverter) {
        this.employeeFormToDTOConverter = employeeFormToDTOConverter;
    }

}
