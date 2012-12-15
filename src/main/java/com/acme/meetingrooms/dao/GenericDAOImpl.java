package com.acme.meetingrooms.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

import lombok.Data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;

/**
 * A JPA based implementation of the {@link GenericDAO} interface.
 * @author Istvan_Hever
 * @param <T> asdf
 */
@Data
public abstract class GenericDAOImpl<T> implements GenericDAO<T> {

    private static final String EXCEPTIONS_PERSISTENCE_DATABASE_ERROR = "exceptions.persistence.database.error";

    private static final Logger LOG = LoggerFactory.getLogger("asdf");

    private EntityManagerFactory entityManagerFactory;
    private EntityManager manager;

    private MessageSource messages;

    /**
     * Default Constructor.
     */
    public GenericDAOImpl() {
    }

    /**
     * Constructor.
     * @param entityManager an {@link EntityManager} instance
     */
    public GenericDAOImpl(EntityManager entityManager) {
        manager = entityManager;
    }

    /**
     * initialization of the object.
     */
    @PostConstruct
    public void init() {
        manager = entityManagerFactory.createEntityManager();
    }

    @Override
    public T getById(long id) throws Exception {
        T entity = null;
        try {
            entity = (T) manager.createQuery("SELECT e FROM EmployeeEntity e WHERE id = :id").setParameter("id", id).getSingleResult();
        } catch (NoResultException nre) {
            throwEntityNotFoundException();
        } catch (Exception e) {
            String message = messages.getMessage(EXCEPTIONS_PERSISTENCE_DATABASE_ERROR, new Object[]{id}, null);
            throw new DatabaseErrorException(message);
        }
        if (entity == null) {
            throwEntityNotFoundException();
        }
        return entity;
    }

    @Override
    public List<T> getAll() {
        List<T> entities = new ArrayList<T>();
        try {
            entities = (List<T>) manager.createQuery("SELECT e FROM EmployeeEntity e").getResultList();
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        return entities;
    }

    @Override
    public List<T> get(Long from, Long step) {
        List<T> employees = new ArrayList<T>();
        try {
            employees = (List<T>) manager.createQuery("SELECT e FROM EmployeeEntity e").setFirstResult(from.intValue())
                    .setMaxResults(step.intValue()).getResultList();
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        return employees;
    }

    @Override
    public void add(T entity) {
        try {
            manager.getTransaction().begin();
            manager.persist(entity);
            manager.getTransaction().commit();
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }

    @Override
    public void remove(long id) {
        try {
            manager.getTransaction().begin();
            manager.createQuery("DELETE FROM EmployeeEntity e WHERE e.id = :id").setParameter("id", id).executeUpdate();
            manager.getTransaction().commit();
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }

    @Override
    public void update(T employee) {
        //        try {
        //            manager.getTransaction().begin();
        //            EmployeeEntity updated = getById(employee.getId());
        //            updated.setName(employee.getName());
        //            updated.setEmail(employee.getEmail());
        //            //manager.(employee);
        //            manager.merge(updated);
        //            manager.getTransaction().commit();
        //        } catch (Exception e) {
        //            LOG.error(e.getMessage());
        //        }
    }

    @Override
    public void remove(T entity) {
        try {
            manager.getTransaction().begin();
            manager.remove(entity);
            manager.getTransaction().commit();
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }

    @Override
    public Long count() {
        Long numberOfEntities = 0L;
        try {
            manager.getTransaction().begin();
            numberOfEntities = (Long) manager.createQuery("SELECT COUNT(e.id) FROM EmployeeEntity e").getSingleResult();
            manager.getTransaction().commit();
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        return numberOfEntities;
    }

    protected abstract void throwEntityNotFoundException() throws Exception;

}
