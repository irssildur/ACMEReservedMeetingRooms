package com.acme.meetingrooms.service.converter;

/**
 * Generic Interface for Converting Employee representations from one to another.
 * @author Istvan_Hever
 *
 * @param <T> object that should be converted. Generic.
 * @param <K> converted object. Generic.
 */
public interface EmployeeConverter<T, K> {

    /**
     * Generic method for Converting Employee representations from one to another.
     * @param convertable an object of a T type that should be converted. Generic.
     * @return an object of a K type. Generic.
     */
    K convert(T convertable);

}