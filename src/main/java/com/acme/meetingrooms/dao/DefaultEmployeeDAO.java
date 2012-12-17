package com.acme.meetingrooms.dao;

import com.acme.meetingrooms.dao.entity.EmployeeEntity;

/**
 * DAO for the EmployeeEntity class.
 * @author Istvan_Hever
 *
 */
public class DefaultEmployeeDAO extends GenericDAOImpl<EmployeeEntity> {

    private static final String EXCEPTIONS_PERSISTENCE_ENTITY_NOT_FOUND = "exceptions.persistence.employeeentity.not.found";

    @Override
    protected void throwEntityNotFoundException() throws Exception {
        String message = super.getMessages().getMessage(EXCEPTIONS_PERSISTENCE_ENTITY_NOT_FOUND, new Object[]{""}, null);
        throw new EmployeeNotFoundException(message);

    }
}
