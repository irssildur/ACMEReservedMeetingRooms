package com.acme.meetingrooms.service.converter;

import lombok.Data;

import org.springframework.core.convert.converter.Converter;

import com.acme.meetingrooms.dao.entity.AuthorityEntity;
import com.acme.meetingrooms.service.dto.AuthorityDTO;

/**
 * From AuthorityEntity to DTO converter.
 * @author Istvan_Hever
 *
 */
@Data
public class AuthorityEntityToDTOConverter implements Converter<AuthorityEntity, AuthorityDTO> {

    @Override
    public AuthorityDTO convert(AuthorityEntity source) {
        AuthorityDTO converted = new AuthorityDTO();
        converted.setId(source.getId());
        converted.setAuthority(source.getAuthority());
        return converted;
    }

}
