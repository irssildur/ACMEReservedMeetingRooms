package com.acme.meetingrooms.service.builder;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.acme.meetingrooms.controller.form.EmployeeForm;

/** Test case for the EmployeeFormBuilder class.
 * @author Istvan_Hever
 *
 */
public class EmployeeFormBuilderTest {

    private static final long EMPLOYEE_ID = 4;
    private static final String EMPLOYEE_EMAIL = "eemail";
    private static final String EMPLOYEE_NAME = "namee";

    private EmployeeFormBuilder underTest;

    /** Setting up.
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        underTest = new EmployeeFormBuilder();
    }

    /**
     * Test method for {@link com.acme.meetingrooms.service.builder.EmployeeFormBuilder#withName(java.lang.String)}.
     */
    @Test
    public void testWithName() {
        // GIVEN
        // WHEN
        underTest.withName(EMPLOYEE_NAME);
        EmployeeForm actual = underTest.build();
        // THEN
        Assert.assertEquals(EMPLOYEE_NAME, actual.getName());
    }

    /**
     * Test method for {@link com.acme.meetingrooms.service.builder.EmployeeFormBuilder#withEmail(java.lang.String)}.
     */
    @Test
    public void testWithEmail() {
        // GIVEN
        // WHEN
        underTest.withEmail(EMPLOYEE_EMAIL);
        EmployeeForm actual = underTest.build();
        // THEN
        Assert.assertEquals(EMPLOYEE_EMAIL, actual.getEmail());
    }

    @Test
    public void testWithNameAndEmail() {
        // GIVEN
        // WHEN
        underTest.withName(EMPLOYEE_NAME);
        underTest.withEmail(EMPLOYEE_EMAIL);
        EmployeeForm actual = underTest.build();
        // THEN
        Assert.assertEquals(EMPLOYEE_NAME, actual.getName());
        Assert.assertEquals(EMPLOYEE_EMAIL, actual.getEmail());
    }

    @Test
    public void testWithNameAndEmailAndId() {
        // GIVEN
        // WHEN
        underTest.withId(EMPLOYEE_ID);
        underTest.withName(EMPLOYEE_NAME);
        underTest.withEmail(EMPLOYEE_EMAIL);
        EmployeeForm actual = underTest.build();
        // THEN
        Assert.assertEquals(EMPLOYEE_NAME, actual.getName());
        Assert.assertEquals(EMPLOYEE_EMAIL, actual.getEmail());
    }

}
