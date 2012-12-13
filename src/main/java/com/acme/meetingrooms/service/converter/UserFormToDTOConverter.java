package com.acme.meetingrooms.service.converter;

import lombok.Data;

import org.springframework.core.convert.converter.Converter;

import com.acme.meetingrooms.controller.form.UserForm;
import com.acme.meetingrooms.service.dto.UserDTO;

/**
 * From UserForm to UserDTO converter.
 * @author Istvan_Hever
 *
 */
@Data
public class UserFormToDTOConverter implements Converter<UserForm, UserDTO> {

    private EmployeeFormToDTOConverter employeeFormToDTOConverter;

    @Override
    public UserDTO convert(UserForm convertable) {
        UserDTO converted = new UserDTO();
        converted.setId(convertable.getId());
        converted.setAuthorities(convertable.getAuthorities());
        converted.setUsername(convertable.getUsername());
        converted.setAccountNonExpired(convertable.getAccountNonExpired());
        converted.setAccountNonLocked(convertable.getAccountNonLocked());
        converted.setCredentialsNonExpired(convertable.getCredentialsNonExpired());
        converted.setEnabled(convertable.getEnabled());
        converted.setEmployeeDto(employeeFormToDTOConverter.convert(convertable.getEmployeeForm()));
        return converted;
    }

}
