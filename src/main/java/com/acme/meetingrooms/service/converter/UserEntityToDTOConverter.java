package com.acme.meetingrooms.service.converter;

import lombok.Data;

import org.springframework.core.convert.converter.Converter;

import com.acme.meetingrooms.dao.entity.UserEntity;
import com.acme.meetingrooms.service.dto.UserDTO;

/**
 * Convertert from UserEntity to UserDTO.
 * @author Istvan_Hever
 *
 */
@Data
public class UserEntityToDTOConverter implements Converter<UserEntity, UserDTO> {

    private EmployeeDAOToDTOConverter employeeDAOToDTOConverter;

    @Override
    public UserDTO convert(UserEntity convertable) {
        UserDTO converted = new UserDTO();
        converted.setId(convertable.getId());
        converted.setAuthorities(convertable.getAuthorities());
        converted.setUsername(convertable.getUsername());
        converted.setAccountNonExpired(convertable.getAccountNonExpired());
        converted.setAccountNonLocked(convertable.getAccountNonLocked());
        converted.setCredentialsNonExpired(convertable.getCredentialsNonExpired());
        converted.setEnabled(convertable.getEnabled());
        converted.setEmployeeDto(employeeDAOToDTOConverter.convert(convertable.getEmployeeEntity()));
        return converted;
    }

}
