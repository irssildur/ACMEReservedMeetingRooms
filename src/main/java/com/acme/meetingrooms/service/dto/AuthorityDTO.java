package com.acme.meetingrooms.service.dto;

import java.util.Set;

import lombok.Data;

import org.springframework.security.core.GrantedAuthority;

/**
 * 
 * @author Istvan_Hever
 *
 */
@Data
public class AuthorityDTO implements GrantedAuthority {

    private Long id;
    private String authority;
    private Set<UserDTO> users;

    @Override
    public String getAuthority() {
        return authority;
    }

}
