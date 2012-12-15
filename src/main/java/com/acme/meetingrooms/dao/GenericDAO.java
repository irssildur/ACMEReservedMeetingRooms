package com.acme.meetingrooms.dao;

import java.util.List;

/**
 * Interface for the DAOs.
 * @author Istvan_Hever
 * @param <T> type of the Entity which the DAO should manage.
 */
public interface GenericDAO<T> {

    /**
     * Gets an Employee from the repository. If there are no employees in the repo, it throws .
     * @param id a long id which identifies the employee.
     * @return List of EmployeesSS
     * @throws Exception if there is no specified Entity.
     */
    T getById(long id) throws Exception;

    /**
     * Lists all of the Employees from the repository. If there are no employees in the repo, it returns an empty list.
     * @return List of Employees
     */
    List<T> getAll();

    /**
     * Get a list of Employees from the "from" parameter from in the length specified by the "step" parameter.
     * @param from value of where the List should start
     * @param step value of the length of the list
     * @return List of Employees
     */
    List<T> get(Long from, Long step);

    /**
     * Adds a new employee to the repository.
     * @param employee an Employee which has to be added to the repository.
     */
    void add(T employee);

    /**
     * Removes an employee from the repository, identified by an id.
     * @param id a long, identifying the Employee which should be removed.
     */
    void remove(long id);

    /**
     * Updates an employee with the new data.
     * @param employee an Employee which has to be updated in the repository.
     */
    void update(T employee);

    /**
     * Removes the employee.
     * @param employee the employee that should be removed.
     */
    void remove(T employee);

    /**
     * Counts the employees.
     * @return the number of the employees.
     */
    Long count();
}