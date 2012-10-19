package com.acme.meetingrooms.service;

import java.util.List;

import com.acme.meetingrooms.service.dto.EmployeeDTO;
import com.acme.meetingrooms.service.exceptions.EmployeeNotFoundException;

/**
 * Interface for the Employee Service.
 * @author Istvan_Hever
 */
public interface EmployeeService {

    /**
     * Gets an Employee from the repository. If there are no employees in the repo, it throws an EmployeeNotFoundException.
     * @param id a long id which identifies the employee.
     * @return List of Employees
     * @throws EmployeeNotFoundException as
     */
    EmployeeDTO getEmployeeById(long id) throws EmployeeNotFoundException;

    /**
     * Lists all of the Employees from the repository. If there are no employees in the repo, it returns an empty list.
     * @return List of Employees
     */
    List<EmployeeDTO> getAllEmployees();

    /**
     * Adds a new employee to the repository.
     * @param employee an Employee which has to be added to the repository.
     */
    void addEmployee(EmployeeDTO employee);

    /**
     * Removes an employee from the repository, identified by an id.
     * @param id a long, identifying the Employee which should be removed.
     */
    void removeEmployee(long id);

    /**
     * Updates an employee with the new data.
     * @param employee an Employee which has to be updated in the repository.
     */
    void updateEmployee(EmployeeDTO employee);

    /**
     * Removes the employee.
     * @param employee the employee that should be removed.
     */
    void removeEmployee(EmployeeDTO employee);

}
