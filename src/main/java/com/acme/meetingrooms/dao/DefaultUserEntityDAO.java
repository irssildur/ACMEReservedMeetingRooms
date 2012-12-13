package com.acme.meetingrooms.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import lombok.Data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.acme.meetingrooms.dao.entity.UserEntity;

/**
 * asdf.
 * @author Istvan_Hever
 *
 */
@Data
public class DefaultUserEntityDAO implements UserEntityDAO {

    private static Logger logger = LoggerFactory.getLogger(DefaultUserEntityDAO.class);

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    /**
     * Default Constructor.
     */
    public DefaultUserEntityDAO() {
    }

    /**
     * Constructor.
     * @param entityManager an {@link EntityManager} instance
     */
    public DefaultUserEntityDAO(EntityManager em) {
        entityManager = em;
    }

    /**
     * initialization of the object.
     */
    @PostConstruct
    public void init() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public UserEntity loadUserByUsername(String username) {
        UserEntity entity;
        try {
            entity = entityManager.createQuery("Select e FROM e UserEntity where username = :username", UserEntity.class)
                    .setParameter("username", username).getSingleResult();
        } catch (Exception e) {
            throw new UsernameNotFoundException(username);
        }
        return entity;
    }

    @Override
    public List<UserEntity> loadAllUser() {
        List<UserEntity> users = new ArrayList<UserEntity>();
        try {
            entityManager.getTransaction().begin();
            users = entityManager.createQuery("SELECT e FROM UserEntity e", UserEntity.class).getResultList();
        } catch (Exception e) {
            logger.debug(e.getMessage());
        }
        return users;
    }

    @Override
    public void addUser(UserEntity userEntity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(userEntity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            logger.error("Couldn't add user: [" + userEntity + "]");
        }
    }

    @Override
    public List<UserEntity> getAllUsers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<UserEntity> getUserEntities(Long from, Long step) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removeUser(Long id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeUser(UserEntity user) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateUser(UserEntity user) {
        // TODO Auto-generated method stub

    }

    @Override
    public Long countUsers() {
        // TODO Auto-generated method stub
        return null;
    }

}
