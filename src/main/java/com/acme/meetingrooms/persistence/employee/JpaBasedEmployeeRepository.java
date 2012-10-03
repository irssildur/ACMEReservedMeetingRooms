package com.acme.meetingrooms.persistence.employee;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.acme.meetingrooms.domain.employee.Employee;

/**
 * A Jpa based implementation of the {@link EmployeeRepository} interface.
 * @author Istvan_Hever
 *
 */
public class JpaBasedEmployeeRepository implements EmployeeRepository {

    private static final Logger logger = LoggerFactory.getLogger(JpaBasedEmployeeRepository.class);
    private EntityManager manager;

    public JpaBasedEmployeeRepository(EntityManager entityManager) {
        manager = entityManager;
    }

    /* (non-Javadoc)
     * @see com.acme.meetingrooms.persistence.EmployeeRepository#getAllEmployees()
     */
    public List<Employee> getAllEmployees() {

        List<Employee> employees = new ArrayList<Employee>();

        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        try {
            employees = manager.createQuery("Select e From Employee e", Employee.class).getResultList();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        transaction.commit();
        return employees;
    }

    /* (non-Javadoc)
     * @see com.acme.meetingrooms.persistence.EmployeeRepository#addEmployee(com.acme.meetingrooms.domain.Employee)
     */
    public void addEmployee(Employee employee) {

        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        try {
            manager.persist(employee);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        transaction.commit();
    }

    public void removeEmployee(Employee employee) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        try {
            manager.remove(employee);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        transaction.commit();
    }

    /* (non-Javadoc)
     * @see com.acme.meetingrooms.persistence.EmployeeRepository#removeEmployee(long)
     */
    public void removeEmployee(long id) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        try {
            manager.createQuery("DELETE FROM Employee e WHERE e.id = :id").setParameter("id", id);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        transaction.commit();
    }

    /* (non-Javadoc)
     * @see com.acme.meetingrooms.persistence.EmployeeRepository#updateEmployee(com.acme.meetingrooms.domain.Employee)
     */
    public void updateEmployee(Employee employee) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        try {
            manager.merge(employee);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        transaction.commit();
    }

}
