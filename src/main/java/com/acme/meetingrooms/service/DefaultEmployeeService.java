package com.acme.meetingrooms.service;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import com.acme.meetingrooms.dao.EmployeeDAO;
import com.acme.meetingrooms.dao.EmployeeNotFoundException;
import com.acme.meetingrooms.dao.entity.EmployeeEntity;
import com.acme.meetingrooms.service.dto.EmployeeDTO;

/**
 * Default implementation for {@link EmployeeService}.
 */
@Data
public class DefaultEmployeeService implements EmployeeService {

    private static Logger logger = LoggerFactory.getLogger(DefaultEmployeeService.class);

    private EmployeeDAO dao;
    private Converter<EmployeeEntity, EmployeeDTO> employeeDAOToDTOConverter;
    private Converter<EmployeeDTO, EmployeeEntity> employeeDTOToDAOConverter;


    /**
     * Default constructor.
     */
    public DefaultEmployeeService() {

    }

    /**
     * Constructor.
     * @param dao an {@link EmployeeDAO} object
     * @param employeeConverter an {@link EmployeeConverter} object
     */
    public DefaultEmployeeService(EmployeeDAO dao, Converter<EmployeeEntity, EmployeeDTO> employeeConverter) {
        this.dao = dao;
        this.employeeDAOToDTOConverter = employeeConverter;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> rawEmployees = dao.getAllEmployees();
        List<EmployeeDTO> employees = new ArrayList<EmployeeDTO>();
        for (EmployeeEntity employeeEntity : rawEmployees) {
            employees.add(employeeDAOToDTOConverter.convert(employeeEntity));
            logger.debug("DES: " + employees.get(employees.size() - 1).getId());
        }
        return employees;
    }

    @Override
    public List<EmployeeDTO> getEmployees(Long from, Long step) {
        if (from < 0 && step < 0) {
            throw new IndexOutOfBoundsException();
        }
        List<EmployeeEntity> rawEmployees = dao.getEmployees(from, step);
        List<EmployeeDTO> employees = new ArrayList<EmployeeDTO>();
        for (EmployeeEntity employeeEntity : rawEmployees) {
            employees.add(employeeDAOToDTOConverter.convert(employeeEntity));
            logger.debug("DES: " + employees.get(employees.size() - 1).getId());
        }
        return employees;
    }

    @Override
    public EmployeeDTO getEmployeeById(long id) throws EmployeeNotFoundException {
        EmployeeEntity employeeDAO = dao.getEmployeeById(id);
        EmployeeDTO employee = employeeDAOToDTOConverter.convert(employeeDAO);
        return employee;
    }

    @Override
    public void addEmployee(EmployeeDTO employee) {
        EmployeeEntity employeeDAO = employeeDTOToDAOConverter.convert(employee);
        dao.addEmployee(employeeDAO);
    }

    @Override
    public void removeEmployee(long id) {
        // TODO check??
        dao.removeEmployee(id);
    }

    @Override
    public void updateEmployee(EmployeeDTO employee) {
        EmployeeEntity employeeDAO = employeeDTOToDAOConverter.convert(employee);
        dao.updateEmployee(employeeDAO);
    }

    @Override
    public void removeEmployee(EmployeeDTO employee) {
        EmployeeEntity employeeDAO = employeeDTOToDAOConverter.convert(employee);
        dao.removeEmployee(employeeDAO);
    }

    @Override
    public Long countEmployees() {
        Long numberOfEmployees = dao.countEmployees();
        return numberOfEmployees;
    }

}
