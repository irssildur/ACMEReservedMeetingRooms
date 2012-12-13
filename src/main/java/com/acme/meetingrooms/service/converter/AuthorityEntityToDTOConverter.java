package com.acme.meetingrooms.service.converter;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

import org.springframework.core.convert.converter.Converter;

import com.acme.meetingrooms.dao.entity.AuthorityEntity;
import com.acme.meetingrooms.dao.entity.UserEntity;
import com.acme.meetingrooms.service.dto.AuthorityDTO;
import com.acme.meetingrooms.service.dto.UserDTO;

/**
 * From AuthorityEntity to DTO converter.
 * @author Istvan_Hever
 *
 */
@Data
public class AuthorityEntityToDTOConverter implements Converter<AuthorityEntity, AuthorityDTO> {

    private UserEntityToDTOConverter userEntityToDTOConverter;

    @Override
    public AuthorityDTO convert(AuthorityEntity source) {
        AuthorityDTO converted = new AuthorityDTO();
        converted.setId(source.getId());
        converted.setAuthority(source.getAuthority());
        Set<UserDTO> userDTOs = new HashSet<UserDTO>();
        for (UserEntity entity : source.getUsers()) {
            userDTOs.add(userEntityToDTOConverter.convert(entity));
        }
        converted.setUsers(userDTOs);
        return converted;
    }

}
