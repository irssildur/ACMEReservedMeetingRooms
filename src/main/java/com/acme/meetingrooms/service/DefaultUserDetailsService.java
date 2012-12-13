package com.acme.meetingrooms.service;

import java.util.List;

import lombok.Data;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.acme.meetingrooms.dao.UserEntityDAO;
import com.acme.meetingrooms.dao.entity.UserEntity;
import com.acme.meetingrooms.service.converter.UserEntityToDTOConverter;
import com.acme.meetingrooms.service.dto.UserDTO;

/**
 * asdf.
 * @author Istvan_Hever
 *
 */
@Data
public class DefaultUserDetailsService implements UserDetailsService {

    private UserEntityDAO userEntityDAO;
    private UserEntityToDTOConverter userEntityToUserDTOConverter;

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserEntity userEntity = userEntityDAO.loadUserByUsername(username);
        UserDTO userDto = userEntityToUserDTOConverter.convert(userEntity);
        return userDto;
    }

    List<UserDTO> getAllUsers() {
        return null;
    }

    List<UserDTO> getUsers(Long from, Long step) {
        return null;
    }

    void addUser(UserDTO user) {
    }

    void removeUser(long id) {
    }

    void updateUser(UserDTO user) {
    }

    void removeUser(UserDTO user) {
    }

    Long countUsers() {
        return null;
    }

}
