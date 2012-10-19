package com.acme.meetingrooms.service.factory;

import com.acme.meetingrooms.service.builder.EmployeeBuilder;

/**
 * Abstract factory for creating specific EmployeeBuilders.
 * @author Istvan_Hever
 *
 * @param <T> 
 */
public interface EmployeeBuilderFactory<T> {

    EmployeeBuilder<T> createBuilder();

}