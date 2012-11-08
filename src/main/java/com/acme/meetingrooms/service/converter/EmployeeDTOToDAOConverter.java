package com.acme.meetingrooms.service.converter;

import org.springframework.core.convert.converter.Converter;

import com.acme.meetingrooms.dao.entity.EmployeeEntity;
import com.acme.meetingrooms.service.dto.EmployeeDTO;

/**
 * Concrete implementation of the interface EmployeeConverter.
 * @author Istvan_Hever
 */
public class EmployeeDTOToDAOConverter implements Converter<EmployeeDTO, EmployeeEntity> {


    /**
     * Generic method for Converting Employee representations from one to another.
     * @param convertable an EmployeeDAO that should be converted.
     * @return an EmployeeDTO.
     */
    public EmployeeEntity convert(EmployeeDTO convertable) {

        EmployeeEntity converted = new EmployeeEntity();
        converted.setId(convertable.getId());
        converted.setName(convertable.getName());
        converted.setEmail(convertable.getEmail());

        return converted;
    }

}
