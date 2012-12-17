package com.acme.meetingrooms.dao;

/**
 * Exception that should be thrown when there are no User.
 * @author Istvan_Hever
 *
 */
public class UserNotFoundException extends Exception {

    /**
     * Constructor.
     * @param message explanation of the problem in human readable format
     */
    public UserNotFoundException(String message) {
        super(message);
    }

}
