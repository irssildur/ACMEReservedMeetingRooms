package com.acme.meetingrooms.service.converter;

import lombok.Data;

import org.springframework.core.convert.converter.Converter;

import com.acme.meetingrooms.controller.form.AuthorityForm;
import com.acme.meetingrooms.service.dto.AuthorityDTO;

/**
 * From AuthorityForm to DTO converter.
 * @author Istvan_Hever
 *
 */
@Data
public class AuthorityFormToDTOConverter implements Converter<AuthorityForm, AuthorityDTO> {

    @Override
    public AuthorityDTO convert(AuthorityForm source) {
        AuthorityDTO converted = new AuthorityDTO();
        converted.setId(source.getId());
        converted.setAuthority(source.getAuthority());
        return converted;
    }

}
