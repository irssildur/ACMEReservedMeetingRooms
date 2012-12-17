package com.acme.meetingrooms.dao;

import com.acme.meetingrooms.dao.entity.AuthorityEntity;

/**
 * DAO for the AuthorityEntity class.
 * @author Istvan_Hever
 *
 */
public class DefaultAuthorityDAO extends GenericDAOImpl<AuthorityEntity> {

    private static final String EXCEPTIONS_PERSISTENCE_ENTITY_NOT_FOUND = "exceptions.persistence.authorityentity.not.found";

    @Override
    protected void throwEntityNotFoundException() throws Exception {
        String message = super.getMessages().getMessage(EXCEPTIONS_PERSISTENCE_ENTITY_NOT_FOUND, new Object[]{""}, null);
        throw new AuthorityNotFoundException(message);

    }

}
