package com.acme.meetingrooms.persistence.employee;

import static org.junit.Assert.fail;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import com.acme.meetingrooms.domain.employee.Employee;

public class JpaBasedEmployeeRepositoryTest {

    private EmployeeRepository underTest;

    @Before
    public void setUp() throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");
        underTest = new JpaBasedEmployeeRepository(factory.createEntityManager());
    }

    @Test
    public void testJpaBasedEmployeeRepository() {
        Employee employee = new Employee();
        employee.setEmail("a12sdf");
        employee.setName("asasfaaa12");
        underTest.addEmployee(employee);
    }

    @Test
    public void testGetAllEmployees() {
        fail("Not yet implemented");
    }

    @Test
    public void testAddEmployee() {
        fail("Not yet implemented");
    }

    @Test
    public void testRemoveEmployeeEmployee() {
        fail("Not yet implemented");
    }

    @Test
    public void testRemoveEmployeeLong() {
        fail("Not yet implemented");
    }

    @Test
    public void testUpdateEmployee() {
        fail("Not yet implemented");
    }

}
