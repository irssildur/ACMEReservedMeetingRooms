package com.acme.meetingrooms.service.factory;

import com.acme.meetingrooms.dao.entity.EmployeeEntity;
import com.acme.meetingrooms.service.builder.EmployeeEntityBuilder;

public class EmployeeDAOBuilderFactory implements EmployeeBuilderFactory<EmployeeEntity> {

    /* (non-Javadoc)
     * @see com.acme.meetingrooms.service.factory.EmployeeBuilderFactory#createBuilder()
     */
    @Override
    public EmployeeEntityBuilder createBuilder() {
        return new EmployeeEntityBuilder();
    }

}
