package com.acme.meetingrooms.service;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import com.acme.meetingrooms.dao.EmployeeNotFoundException;
import com.acme.meetingrooms.dao.GenericDAO;
import com.acme.meetingrooms.dao.entity.EmployeeEntity;
import com.acme.meetingrooms.service.dto.EmployeeDTO;

/**
 * Default implementation for {@link EmployeeService}.
 */
@Data
public class DefaultEmployeeService implements EmployeeService {

    private static Logger logger = LoggerFactory.getLogger(DefaultEmployeeService.class);

    private GenericDAO<EmployeeEntity> dao;
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
    public DefaultEmployeeService(GenericDAO<EmployeeEntity> dao, Converter<EmployeeEntity, EmployeeDTO> employeeConverter) {
        this.dao = dao;
        this.employeeDAOToDTOConverter = employeeConverter;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> rawEmployees = dao.getAll();
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
        List<EmployeeEntity> rawEmployees = dao.get(from, step);
        List<EmployeeDTO> employees = new ArrayList<EmployeeDTO>();
        for (EmployeeEntity employeeEntity : rawEmployees) {
            employees.add(employeeDAOToDTOConverter.convert(employeeEntity));
            logger.debug("DES: " + employees.get(employees.size() - 1).getId());
        }
        return employees;
    }

    @Override
    public EmployeeDTO getEmployeeById(long id) throws EmployeeNotFoundException {
        EmployeeDTO employee = null;
        try {

            EmployeeEntity employeeDAO = dao.getById(id);
            employee = employeeDAOToDTOConverter.convert(employeeDAO);
        } catch (Exception e) {
            logger.error("asdf");
        }
        return employee;
    }

    @Override
    public void addEmployee(EmployeeDTO employee) {
        EmployeeEntity employeeDAO = employeeDTOToDAOConverter.convert(employee);
        dao.add(employeeDAO);
    }

    @Override
    public void removeEmployee(long id) {
        // TODO check??
        dao.remove(id);
    }

    @Override
    public void updateEmployee(EmployeeDTO employee) {
        EmployeeEntity employeeDAO = employeeDTOToDAOConverter.convert(employee);
        dao.update(employeeDAO);
    }

    @Override
    public void removeEmployee(EmployeeDTO employee) {
        EmployeeEntity employeeDAO = employeeDTOToDAOConverter.convert(employee);
        dao.remove(employeeDAO);
    }

    @Override
    public Long countEmployees() {
        Long numberOfEmployees = dao.count();
        return numberOfEmployees;
    }

}
