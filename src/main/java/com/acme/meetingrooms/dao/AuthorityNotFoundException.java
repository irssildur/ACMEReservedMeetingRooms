package com.acme.meetingrooms.dao;

/**
 * Exception that should be thrown when there are no Authority.
 * @author Istvan_Hever
 *
 */
public class AuthorityNotFoundException extends Exception {
    /**
     * Constructor.
     * @param message explanation of the problem in human readable format
     */
    public AuthorityNotFoundException(String message) {
        super(message);
    }
}