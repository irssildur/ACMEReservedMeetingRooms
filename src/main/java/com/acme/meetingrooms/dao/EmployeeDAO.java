package com.acme.meetingrooms.dao;

import java.util.List;

import com.acme.meetingrooms.dao.entity.EmployeeEntity;

/**
 * Interface for the Employee Repositories.
 * @author Istvan_Hever
 */
public interface EmployeeDAO {

    /**
     * Gets an Employee from the repository. If there are no employees in the repo, it throws .
     * @param id a long id which identifies the employee.
     * @return List of EmployeesSS
     * @throws EmployeeNotFoundException as
     */
    EmployeeEntity getEmployeeById(long id) throws EmployeeNotFoundException;

    /**
     * Lists all of the Employees from the repository. If there are no employees in the repo, it returns an empty list.
     * @return List of Employees
     */
    List<EmployeeEntity> getAllEmployees();

    /**
     * Adds a new employee to the repository.
     * @param employee an Employee which has to be added to the repository.
     */
    void addEmployee(EmployeeEntity employee);

    /**
     * Removes an employee from the repository, identified by an id.
     * @param id a long, identifying the Employee which should be removed.
     */
    void removeEmployee(long id);

    /**
     * Updates an employee with the new data.
     * @param employee an Employee which has to be updated in the repository.
     */
    void updateEmployee(EmployeeEntity employee);

    /**
     * Removes the employee.
     * @param employee the employee that should be removed.
     */
    void removeEmployee(EmployeeEntity employee);

}