package com.acme.meetingrooms.service.builder;

/**
 * Generic interface for Employee builders.
 * @author Istvan_Hever
 *
 * @param <T> the generic type to build.
 */
public interface EmployeeBuilder<T> {

    EmployeeBuilder<T> getBuilder();

    /**
     * Builds the Employee with ID.
     * @param id the id of the Employee
     * @return the builder
     */
    EmployeeBuilder<T> withId(long id);

    /**
     * Builds the Employee with name.
     * @param name the name of the Employee
     * @return the builder
     */
    EmployeeBuilder<T> withName(String name);

    /**
     * Builds the Employee with email address.
     * @param email the email address of the Employee
     * @return the builder
     */
    EmployeeBuilder<T> withEmail(String email);

    /**
     * Builds the Employee.
     * @return specified T typed Employee
     */
    T build();

}