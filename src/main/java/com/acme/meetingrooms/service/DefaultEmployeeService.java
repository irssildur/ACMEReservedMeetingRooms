package com.acme.meetingrooms.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.acme.meetingrooms.dao.entity.EmployeeEntity;
import com.acme.meetingrooms.service.converter.EmployeeConverter;
import com.acme.meetingrooms.service.dto.EmployeeDTO;
import com.acme.meetingrooms.service.exceptions.EmployeeNotFoundException;

/**
 * Default implementation for {@link EmployeeService}.
 */
public class DefaultEmployeeService implements EmployeeService {

    private static Logger logger = LoggerFactory.getLogger(DefaultEmployeeService.class);

    private EmployeeServiceDAO dao;
    private EmployeeConverter<EmployeeEntity, EmployeeDTO> employeeDAOToDTOConverter;
    private EmployeeConverter<EmployeeDTO, EmployeeEntity> employeeDTOToDAOConverter;

    /**
     * Default constructor.
     */
    public DefaultEmployeeService() {

    }

    /**
     * Constructor.
     * @param dao an {@link EmployeeServiceDAO} object
     * @param employeeConverter an {@link EmployeeConverter} object
     */
    public DefaultEmployeeService(EmployeeServiceDAO dao, EmployeeConverter<EmployeeEntity, EmployeeDTO> employeeConverter) {
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

    public EmployeeServiceDAO getDao() {
        return dao;
    }

    public void setDao(EmployeeServiceDAO dao) {
        this.dao = dao;
    }

    public EmployeeConverter<EmployeeEntity, EmployeeDTO> getEmployeeDAOToDTOConverter() {
        return employeeDAOToDTOConverter;
    }

    public void setEmployeeDAOToDTOConverter(EmployeeConverter<EmployeeEntity, EmployeeDTO> employeeDAOToDTOConverter) {
        this.employeeDAOToDTOConverter = employeeDAOToDTOConverter;
    }

    public EmployeeConverter<EmployeeDTO, EmployeeEntity> getEmployeeDTOToDAOConverter() {
        return employeeDTOToDAOConverter;
    }

    public void setEmployeeDTOToDAOConverter(EmployeeConverter<EmployeeDTO, EmployeeEntity> employeeDTOToDAOConverter) {
        this.employeeDTOToDAOConverter = employeeDTOToDAOConverter;
    }

}