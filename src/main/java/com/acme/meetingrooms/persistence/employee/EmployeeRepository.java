package com.acme.meetingrooms.persistence.employee;

import java.util.List;

import com.acme.meetingrooms.domain.employee.Employee;

/**
 * Interface for the Employee Repositories.
 * @author Istvan_Hever
 */
public interface EmployeeRepository {

    /**
     * Lists all of the Employees from the repository. If there are no employees in the repo, it returns an empty list.
     * @return List of Employees
     */
    List<Employee> getAllEmployees();

    /**
     * Adds a new employee to the repository.
     * @param employee an Employee which has to be added to the repository.
     */
    void addEmployee(Employee employee);

    /**
     * Removes an employee from the repository, identified by an id.
     * @param id a long, identifying the Employee which should be removed.
     */
    void removeEmployee(long id);

    /**
     * Updates an employee with the new data.
     * @param employee an Employee which has to be updated in the repository.
     */
    void updateEmployee(Employee employee);

    void removeEmployee(Employee employee);

}