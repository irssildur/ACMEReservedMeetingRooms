package com.acme.meetingrooms.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;

import com.acme.meetingrooms.dao.entity.EmployeeEntity;

/**
 * A JPA based implementation of the {@link EmployeeServiceDAO} interface.
 * @author Istvan_Hever
 *
 */
@Repository
public class DefaultEmployeeServiceDAO implements EmployeeServiceDAO {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultEmployeeServiceDAO.class);

    private EntityManagerFactory entityManagerFactory;
    private EntityManager manager;

    private MessageSource messages;

    /**
     * Default Constructor.
     */
    public DefaultEmployeeServiceDAO() {
    }

    /**
     * Constructor.
     * @param entityManager an {@link EntityManager} instance
     */
    public DefaultEmployeeServiceDAO(EntityManager entityManager) {
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
    public EmployeeEntity getEmployeeById(long id) throws EmployeeNotFoundException {
        EmployeeEntity employee = null;
        try {
            employee = manager.createQuery("SELECT e FROM EmployeeEntity e WHERE id = :id", EmployeeEntity.class).setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException nre) {
            String message = messages.getMessage("entity.not.found", new Object[]{id}, null);
            throw new EmployeeNotFoundException(message);
        } catch (Exception e) {
            String message = messages.getMessage("database.error", new Object[]{id}, null);
            throw new DatabaseErrorException(message);
        }
        if (employee == null) {
            String message = messages.getMessage("entity.not.found", new Object[]{id}, null);
            throw new EmployeeNotFoundException(message);
        }
        return employee;
    }

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        List<EmployeeEntity> employees = new ArrayList<EmployeeEntity>();
        try {
            employees = manager.createQuery("SELECT e FROM EmployeeEntity e", EmployeeEntity.class).getResultList();
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        return employees;
    }

    @Override
    public void addEmployee(EmployeeEntity employee) {
        LOG.info("EmployeeEntity [" + employee + "] is getting added.");
        try {
            manager.getTransaction().begin();
            manager.persist(employee);
            manager.getTransaction().commit();
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }

    @Override
    public void removeEmployee(EmployeeEntity employee) {
        LOG.info("EmployeeEntity [" + employee + "] is getting removed.");
        try {
            manager.getTransaction().begin();
            manager.remove(employee);
            manager.getTransaction().commit();
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }

    @Override
    public void removeEmployee(long id) {
        LOG.info("EmployeeEntity with id: [" + id + "] is getting removed.");
        try {
            manager.getTransaction().begin();
            manager.createQuery("DELETE FROM EmployeeEntity e WHERE e.id = :id").setParameter("id", id).executeUpdate();
            manager.getTransaction().commit();
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }

    @Override
    public void updateEmployee(EmployeeEntity employee) {
        LOG.info("EmployeeEntity [" + employee + "] is getting edited.");
        try {
            LOG.debug(employee.toString());
            manager.getTransaction().begin();
            EmployeeEntity updated = getEmployeeById(employee.getId());
            updated.setName(employee.getName());
            updated.setEmail(employee.getEmail());
            //manager.(employee);
            manager.merge(updated);
            manager.getTransaction().commit();
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public MessageSource getMessages() {
        return messages;
    }

    public void setMessages(MessageSource messages) {
        this.messages = messages;
    }

}
