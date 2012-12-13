package com.acme.meetingrooms.dao;

import java.util.List;

import com.acme.meetingrooms.dao.entity.UserEntity;

/**
 * DAO for UserDetails.
 * @author Istvan_Hever
 *
 */
public interface UserEntityDAO {

    /**
     * Loads a UserEntity by username.
     * @param username the name to load.
     * @return an UserEntity object.
     */
    UserEntity loadUserByUsername(String username);

    /**
     * Persists a User.
     * @param userEntity the userEntity to persist.
     */
    void addUser(UserEntity userEntity);

    /**
     * Lists all user.
     * @return a list of users.
     */
    List<UserEntity> loadAllUser();

    List<UserEntity> getAllUsers();

    List<UserEntity> getUserEntities(Long from, Long step);

    void removeUser(Long id);

    void removeUser(UserEntity user);

    void updateUser(UserEntity user);

    Long countUsers();

}