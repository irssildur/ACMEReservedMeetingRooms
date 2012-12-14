package com.acme.meetingrooms.dao.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.Data;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * asdf.
 * @author Istvan_Hever
 *
 */
@Data
@Entity
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue
    private long id;
    @ManyToMany(targetEntity = AuthorityEntity.class)
    private Set<GrantedAuthority> authorities;
    private String username;
    private String password;
    private Boolean accountNonExpired;
    private Boolean accountNonLocked;
    private Boolean credentialsNonExpired;
    private Boolean enabled;
    @OneToOne
    private EmployeeEntity employeeEntity;

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

}
