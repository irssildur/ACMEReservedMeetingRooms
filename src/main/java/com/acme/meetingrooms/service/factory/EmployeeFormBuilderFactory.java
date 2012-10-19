package com.acme.meetingrooms.service.factory;

import com.acme.meetingrooms.service.builder.EmployeeFormBuilder;

public class EmployeeFormBuilderFactory implements EmployeeBuilderFactory {

    @Override
    public EmployeeFormBuilder createBuilder() {
        return new EmployeeFormBuilder();
    }

}
