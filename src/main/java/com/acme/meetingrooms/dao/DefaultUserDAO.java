package com.acme.meetingrooms.dao;

import com.acme.meetingrooms.dao.entity.UserEntity;

/**
 * 
 * @author Istvan_Hever
 *
 */
public class DefaultUserDAO extends GenericDAOImpl<UserEntity> {

    private static final String EXCEPTIONS_PERSISTENCE_ENTITY_NOT_FOUND = "exceptions.persistence.userentity.not.found";

    @Override
    protected void throwEntityNotFoundException() throws Exception {
        String message = super.getMessages().getMessage(EXCEPTIONS_PERSISTENCE_ENTITY_NOT_FOUND, new Object[]{""}, null);
        throw new EmployeeNotFoundException(message);

    }
}
