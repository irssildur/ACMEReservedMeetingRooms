package com.acme.meetingrooms.service.builder;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.acme.meetingrooms.dao.entity.EmployeeEntity;

/** Test case for the EmployeeDAOBuilder class.
 * @author Istvan_Hever
 *
 */
public class EmployeeDAOBuilderTest {

    private static final String EMPLOYEE_EMAIL = "eemail";
    private static final String EMPLOYEE_NAME = "namee";
    private static final long EMPLOYEE_ID = 4;
    private EmployeeEntityBuilder underTest;

    /** Setting up.
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        underTest = new EmployeeEntityBuilder();
    }

    /**
     * Test method for {@link com.acme.meetingrooms.service.builder.EmployeeEntityBuilder#withId(long)}.
     */
    @Test
    public void testWithId() {
        // GIVEN
        // WHEN
        underTest.withId(EMPLOYEE_ID);
        EmployeeEntity actual = underTest.build();
        // THEN
        Assert.assertEquals(EMPLOYEE_ID, actual.getId());
    }

    /**
     * Test method for {@link com.acme.meetingrooms.service.builder.EmployeeEntityBuilder#withName(java.lang.String)}.
     */
    @Test
    public void testWithName() {
        // GIVEN
        // WHEN
        underTest.withName(EMPLOYEE_NAME);
        EmployeeEntity actual = underTest.build();
        // THEN
        Assert.assertEquals(EMPLOYEE_NAME, actual.getName());
    }

    /**
     * Test method for {@link com.acme.meetingrooms.service.builder.EmployeeEntityBuilder#withEmail(java.lang.String)}.
     */
    @Test
    public void testWithEmail() {
        // GIVEN
        // WHEN
        underTest.withEmail(EMPLOYEE_EMAIL);
        EmployeeEntity actual = underTest.build();
        // THEN
        Assert.assertEquals(EMPLOYEE_EMAIL, actual.getEmail());
    }

    @Test
    public void testWithNameAndEmail() {
        // GIVEN
        // WHEN
        underTest.withName(EMPLOYEE_NAME);
        underTest.withEmail(EMPLOYEE_EMAIL);
        EmployeeEntity actual = underTest.build();
        // THEN
        Assert.assertEquals(EMPLOYEE_NAME, actual.getName());
        Assert.assertEquals(EMPLOYEE_EMAIL, actual.getEmail());
    }

    @Test
    public void testWithNameAndId() {
        // GIVEN
        // WHEN
        underTest.withName(EMPLOYEE_NAME);
        underTest.withId(EMPLOYEE_ID);
        EmployeeEntity actual = underTest.build();
        // THEN
        Assert.assertEquals(EMPLOYEE_NAME, actual.getName());
        Assert.assertEquals(EMPLOYEE_ID, actual.getId());
    }

    @Test
    public void testWithEmailAndId() {
        // GIVEN
        // WHEN
        underTest.withEmail(EMPLOYEE_EMAIL);
        underTest.withId(EMPLOYEE_ID);
        EmployeeEntity actual = underTest.build();
        // THEN
        Assert.assertEquals(EMPLOYEE_EMAIL, actual.getEmail());
        Assert.assertEquals(EMPLOYEE_ID, actual.getId());
    }

    @Test
    public void testWithNameAndEmailAndId() {
        // GIVEN
        // WHEN
        underTest.withId(EMPLOYEE_ID);
        underTest.withName(EMPLOYEE_NAME);
        underTest.withEmail(EMPLOYEE_EMAIL);
        EmployeeEntity actual = underTest.build();
        // THEN
        Assert.assertEquals(EMPLOYEE_ID, actual.getId());
        Assert.assertEquals(EMPLOYEE_NAME, actual.getName());
        Assert.assertEquals(EMPLOYEE_EMAIL, actual.getEmail());
    }

}
