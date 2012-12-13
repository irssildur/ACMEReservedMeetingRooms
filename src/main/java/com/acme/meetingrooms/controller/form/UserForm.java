package com.acme.meetingrooms.controller.form;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

import org.springframework.security.core.GrantedAuthority;

/**
 * asdf.
 * @author Istvan_Hever
 *
 */
@Data
public class UserForm {

    private long id;
    private Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
    private String username;
    private String password;
    private Boolean accountNonExpired = false;
    private Boolean accountNonLocked = false;
    private Boolean credentialsNonExpired = false;
    private Boolean enabled = false;
    private EmployeeForm employeeForm;

}
