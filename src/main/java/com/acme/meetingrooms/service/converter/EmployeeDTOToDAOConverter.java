package com.acme.meetingrooms.service.converter;

import com.acme.meetingrooms.dao.entity.EmployeeEntity;
import com.acme.meetingrooms.service.builder.EmployeeBuilder;
import com.acme.meetingrooms.service.dto.EmployeeDTO;

/**
 * Concrete implementation of the interface EmployeeConverter.
 * @author Istvan_Hever
 */
public class EmployeeDTOToDAOConverter implements EmployeeConverter<EmployeeDTO, EmployeeEntity> {

    private EmployeeBuilder<EmployeeEntity> builder;

    /**
     * Generic method for Converting Employee representations from one to another.
     * @param convertable an EmployeeDAO that should be converted.
     * @return an EmployeeDTO.
     */
    public EmployeeEntity convert(EmployeeDTO convertable) {
        return builder.getBuilder().withId(convertable.getId()).withName(convertable.getName()).withEmail(convertable.getEmail()).build();
    }

    public void setBuilder(EmployeeBuilder<EmployeeEntity> builder) {
        this.builder = builder;
    }
}
