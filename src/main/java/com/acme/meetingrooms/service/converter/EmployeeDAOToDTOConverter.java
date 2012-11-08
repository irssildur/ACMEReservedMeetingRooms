package com.acme.meetingrooms.service.converter;

import org.springframework.core.convert.converter.Converter;

import com.acme.meetingrooms.dao.entity.EmployeeEntity;
import com.acme.meetingrooms.service.dto.EmployeeDTO;

/**
 * Concrete implementation of the interface EmployeeConverter.
 * @author Istvan_Hever
 */
public class EmployeeDAOToDTOConverter implements Converter<EmployeeEntity, EmployeeDTO> {

    /**
     * Generic method for Converting Employee representations from one to another.
     * @param convertable an EmployeeDAO that should be converted.
     * @return an EmployeeDTO.
     */
    public EmployeeDTO convert(EmployeeEntity convertable) {

        EmployeeDTO converted = new EmployeeDTO();
        converted.setId(convertable.getId());
        converted.setName(convertable.getName());
        converted.setEmail(convertable.getEmail());

        return converted;
    }

}
