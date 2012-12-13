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
 * From AuthorityDTO to Entity converter.
 * @author Istvan_Hever
 *
 */
@Data
public class AuthorityDTOToEntityConverter implements Converter<AuthorityDTO, AuthorityEntity> {

    private UserDTOToEntityConverter userDTOToEntityConverter;

    @Override
    public AuthorityEntity convert(AuthorityDTO source) {
        AuthorityEntity converted = new AuthorityEntity();
        converted.setId(source.getId());
        converted.setAuthority(source.getAuthority());
        Set<UserEntity> userEntities = new HashSet<UserEntity>();
        for (UserDTO dto : source.getUsers()) {
            userEntities.add(userDTOToEntityConverter.convert(dto));
        }
        converted.setUsers(userEntities);
        return converted;
    }

}
