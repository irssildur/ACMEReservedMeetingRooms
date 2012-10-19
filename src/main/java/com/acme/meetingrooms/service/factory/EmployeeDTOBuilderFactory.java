package com.acme.meetingrooms.service.factory;

import com.acme.meetingrooms.service.builder.EmployeeDTOBuilder;

public class EmployeeDTOBuilderFactory implements EmployeeBuilderFactory {

    @Override
    public EmployeeDTOBuilder createBuilder() {
        return new EmployeeDTOBuilder();
    }

}
