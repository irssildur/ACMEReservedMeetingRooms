package com.acme.meetingrooms.dao;

/**
 * Exception that should be thrown when there are no Employees.
 * @author Istvan_Hever
 *
 */
public class EmployeeNotFoundException extends Exception {

    /**
     * Constructor.
     * @param message explanation of the problem in human readable format
     */
    public EmployeeNotFoundException(String message) {
        super(message);
    }

}
