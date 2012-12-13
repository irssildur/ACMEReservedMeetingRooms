package com.acme.meetingrooms.service.converter;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

import org.springframework.core.convert.converter.Converter;

import com.acme.meetingrooms.controller.form.AuthorityForm;
import com.acme.meetingrooms.controller.form.UserForm;
import com.acme.meetingrooms.service.dto.AuthorityDTO;
import com.acme.meetingrooms.service.dto.UserDTO;

/**
 * From AuthorityForm to DTO converter.
 * @author Istvan_Hever
 *
 */
@Data
public class AuthorityFormToDTOConverter implements Converter<AuthorityForm, AuthorityDTO> {

    private UserFormToDTOConverter userFormToDTOConverter;

    @Override
    public AuthorityDTO convert(AuthorityForm source) {
        AuthorityDTO converted = new AuthorityDTO();
        converted.setId(source.getId());
        converted.setAuthority(source.getAuthority());
        Set<UserDTO> userDTOs = new HashSet<UserDTO>();
        for (UserForm form : source.getUsers()) {
            userDTOs.add(userFormToDTOConverter.convert(form));
        }
        converted.setUsers(userDTOs);
        return converted;
    }

}
