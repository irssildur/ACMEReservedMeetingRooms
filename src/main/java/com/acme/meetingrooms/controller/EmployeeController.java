package com.acme.meetingrooms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import lombok.Getter;
import lombok.Setter;

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
import com.acme.meetingrooms.dao.EmployeeNotFoundException;
import com.acme.meetingrooms.service.EmployeeService;
import com.acme.meetingrooms.service.dto.EmployeeDTO;

/**
 * Controller.
 * @author Istvan_Hever
 *
 */
@Controller
@RequestMapping(value = "/employees")
public class EmployeeController {

    private static final String SAVE_EDITED_MAPPING = "/save_edited";

    private static final String EDIT_MAPPING = "/edit";

    private static final String REMOVE_MAPPING = "/remove";

    private static final String SAVE_MAPPING = "/save";

    private static final String ADD_MAPPING = "/add";

    private static final String LIST_MAPPING = "/list";

    private static final String LIST_AJAX_MAPPING = "/ajaxlist";

    private static final String EMPLOYEES_LIST_VIEW = "employees/list";

    private static final String EMPLOYEES_LIST_AJAX_VIEW = "employees/listajax";

    private static final String EMPLOYEES_ADD_VIEW = "employees/add";

    private static final String EMPLOYEES_EDIT_VIEW = "employees/edit";

    private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Getter
    @Setter
    private EmployeeService employeeService;
    @Getter
    @Setter
    private Converter<EmployeeForm, EmployeeDTO> employeeFormToDTOConverter;

    /**
     * asdf.
     * @param locale asdf
     * @param model asdf
     * @return asdf
     */

    @RequestMapping(value = LIST_AJAX_MAPPING, method = RequestMethod.GET)
    public String listAjaxEmployees(Model model) {

        return EMPLOYEES_LIST_AJAX_VIEW;
    }

    @RequestMapping(value = {LIST_MAPPING, "/"}, method = RequestMethod.GET)
    public String listEmployees(Model model) {

        List<EmployeeDTO> employees = employeeService.getAllEmployees();

        model.addAttribute("employees", employees);

        return EMPLOYEES_LIST_VIEW;
    }

    @RequestMapping(value = ADD_MAPPING, method = RequestMethod.GET)
    public String addEmployee(Model model, HttpServletRequest request) {

        model.addAttribute("employeeForm", new EmployeeForm());
        return EMPLOYEES_ADD_VIEW;

    }

    @RequestMapping(value = SAVE_MAPPING, method = RequestMethod.POST)
    public String saveEmployee(Model model, @Valid EmployeeForm employeeForm, BindingResult result, RedirectAttributes flash,
            HttpServletRequest request) {

        String url = "";

        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            logger.debug(result.getAllErrors().toString());
            url = EMPLOYEES_ADD_VIEW;
        } else {
            EmployeeDTO employeeDTO = employeeFormToDTOConverter.convert(employeeForm);
            employeeService.addEmployee(employeeDTO);
            flash.addAttribute("msg", "You have succesfully added: " + employeeForm.getName());
            url = "redirect:/" + EMPLOYEES_LIST_VIEW;
        }
        return url;
    }

    @RequestMapping(value = REMOVE_MAPPING)
    public String removeEmployee(@RequestParam(value = "id") String id, Model model, HttpServletRequest request) {

        logger.debug(id);
        Long removeId = Long.parseLong(id);
        employeeService.removeEmployee(removeId);

        //return "redirect:/employees/list";
        return "redirect:/" + EMPLOYEES_LIST_VIEW;
    }

    @RequestMapping(value = EDIT_MAPPING, method = RequestMethod.GET)
    public String editEmployee(@RequestParam(value = "id") String id, Model model, HttpServletRequest request) throws EmployeeNotFoundException {

        Long editId = Long.parseLong(id);

        EmployeeDTO employeeToShow;

        employeeToShow = employeeService.getEmployeeById(editId);

        model.addAttribute("employee", employeeToShow);
        return EMPLOYEES_EDIT_VIEW;

    }

    @RequestMapping(value = SAVE_EDITED_MAPPING, method = RequestMethod.POST)
    public String editEmployee(Model model, @Valid EmployeeForm employee, BindingResult result, HttpServletRequest request) {

        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            logger.debug(result.getAllErrors().toString());
            return EMPLOYEES_EDIT_VIEW;
        } else {
            EmployeeDTO employeeDTO = employeeFormToDTOConverter.convert(employee);
            employeeService.updateEmployee(employeeDTO);
        }

        return "redirect:/" + EMPLOYEES_LIST_VIEW;
    }

}
