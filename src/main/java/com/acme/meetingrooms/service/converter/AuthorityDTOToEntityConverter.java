package com.acme.meetingrooms.service.converter;

import lombok.Data;

import org.springframework.core.convert.converter.Converter;

import com.acme.meetingrooms.dao.entity.AuthorityEntity;
import com.acme.meetingrooms.service.dto.AuthorityDTO;

/**
 * From AuthorityDTO to Entity converter.
 * @author Istvan_Hever
 *
 */
@Data
public class AuthorityDTOToEntityConverter implements Converter<AuthorityDTO, AuthorityEntity> {

    @Override
    public AuthorityEntity convert(AuthorityDTO source) {
        AuthorityEntity converted = new AuthorityEntity();
        converted.setId(source.getId());
        converted.setAuthority(source.getAuthority());
        return converted;
    }

}
