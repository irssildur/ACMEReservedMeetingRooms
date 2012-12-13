package com.acme.meetingrooms.dao;

import java.util.List;

import com.acme.meetingrooms.dao.entity.UserEntity;

/**
 * 
 * @author Istvan_Hever
 *
 */
public class DAO {
    UserEntity loadUserByUsername(String username);

    /**
     * Persists a User.
     * @param userEntity the userEntity to persist.
     */
    void add(UserEntity userEntity);

    /**
     * Lists all user.
     * @return a list of users.
     */
    List<UserEntity> loadAll();

    List<UserEntity> getAll();

    List<UserEntity> getUserEntities(Long from, Long step);

    void remove(Long id);

    void remove(UserEntity user);

    void update(UserEntity user);

    Long count();
}
