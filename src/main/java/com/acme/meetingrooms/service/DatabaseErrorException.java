package com.acme.meetingrooms.service;

/**
 * Exception that should be thrown when there are problems with the database.
 * @author Istvan_Hever
 *
 */
public class DatabaseErrorException extends RuntimeException {

    /**
     * Constructor.
     * @param message explanation of the problem in human readable format
     */
    public DatabaseErrorException(String message) {
        super(message);
    }

}
