package com.acme.meetingrooms.service.builder;

import com.acme.meetingrooms.dao.entity.EmployeeEntity;

/**
 * Concrete implementation of the interface EmployeeBuilder with a type EmployeeDAO.
 * @author Istvan_Hever
 *
 */
public final class EmployeeEntityBuilder implements EmployeeBuilder<EmployeeEntity> {

    private EmployeeEntity entity;

    /**
     * Constructor. Creates a new EmployeeDAO instance.
     */
    private EmployeeEntityBuilder() {
        entity = new EmployeeEntity();
    }

    @Override
    public EmployeeBuilder<EmployeeEntity> getBuilder() {
        return new EmployeeEntityBuilder();
    }

    /**
     * Builds the Employee with ID.
     * @param id the id of the Employee
     * @return the builder
     */
    public EmployeeBuilder<EmployeeEntity> withId(long id) {
        entity.setId(id);
        return this;
    }

    /**
     * Builds the Employee with name.
     * @param name the name of the Employee
     * @return the builder
     */
    public EmployeeBuilder<EmployeeEntity> withName(String name) {
        entity.setName(name);
        return this;
    }

    /**
     * Builds the Employee with email address.
     * @param email the email address of the Employee
     * @return the builder
     */
    public EmployeeBuilder<EmployeeEntity> withEmail(String email) {
        entity.setEmail(email);
        return this;
    }

    /**
     * Builds the Employee.
     * @return the constructed EmployeeDAO
     */
    public EmployeeEntity build() {
        return entity;
    }

}
