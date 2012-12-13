package com.acme.meetingrooms.service.converter;

import lombok.Data;

import org.springframework.core.convert.converter.Converter;

import com.acme.meetingrooms.dao.entity.UserEntity;
import com.acme.meetingrooms.service.dto.UserDTO;

/**
 * From UserDTO to UserEntity converter.
 * @author Istvan_Hever
 *
 */
@Data
public class UserDTOToEntityConverter implements Converter<UserDTO, UserEntity> {

    private EmployeeDTOToDAOConverter employeeDTOToDAOConverter;

    @Override
    public UserEntity convert(UserDTO convertable) {
        UserEntity converted = new UserEntity();
        converted.setId(convertable.getId());
        converted.setAuthorities(convertable.getAuthorities());
        converted.setUsername(convertable.getUsername());
        converted.setAccountNonExpired(convertable.getAccountNonExpired());
        converted.setAccountNonLocked(convertable.getAccountNonLocked());
        converted.setCredentialsNonExpired(convertable.getCredentialsNonExpired());
        converted.setEnabled(convertable.getEnabled());
        converted.setEmployeeEntity(employeeDTOToDAOConverter.convert(convertable.getEmployeeDto()));
        return converted;
    }

}
