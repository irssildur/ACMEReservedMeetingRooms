package com.acme.meetingrooms.service;

import java.util.List;

import lombok.Data;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.acme.meetingrooms.service.dto.UserDTO;

/**
 * asdf.
 * @author Istvan_Hever
 *
 */
@Data
public class DefaultUserDetailsService implements UserDetailsService {

//    private UserEntityDAO userEntityDAO;
//    private UserEntityToDTOConverter userEntityToUserDTOConverter;
//    private UserDTOToEntityConverter userDTOToEntityConverter;

    @Override
    public UserDetails loadUserByUsername(String username) {
//        UserEntity userEntity = userEntityDAO.loadUserByUsername(username);
//        UserDTO userDto = userEntityToUserDTOConverter.convert(userEntity);
        return null;
    }

    List<UserDTO> getAllUsers() {
        return null;
    }

    List<UserDTO> getUsers(Long from, Long step) {
        return null;
    }

    void addUser(UserDTO user) {
//        UserEntity userEntity = userDTOToEntityConverter.convert(user);
//        userEntityDAO.addUser(userEntity);
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
