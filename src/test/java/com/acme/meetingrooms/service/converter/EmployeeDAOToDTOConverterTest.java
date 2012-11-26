package com.acme.meetingrooms.service.converter;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.acme.meetingrooms.dao.entity.EmployeeEntity;
import com.acme.meetingrooms.service.dto.EmployeeDTO;

/**
 * Test for the EmployeeDAOToDTOConverter class.
 * @author Istvan_Hever
 *
 */
public class EmployeeDAOToDTOConverterTest {

    private static final long EMPLOYEE_ID = 4;
    private static final String EMPLOYEE_EMAIL = "email@email.com";
    private static final String EMPLOYEE_NAME = "asdf";
    private EmployeeDAOToDTOConverter underTest;

    /** Setting up.
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        underTest = new EmployeeDAOToDTOConverter();
    }

    /**
     * Test method for {@link com.acme.meetingrooms.service.converter.EmployeeDAOToDTOConverter#convert(com.acme.meetingrooms.dao.entity.EmployeeEntity)}.
     */
    @Test
    public void testConvertShouldPass() {

        // GIVEN

        EmployeeEntity dao = new EmployeeEntity();
        dao.setId(EMPLOYEE_ID);
        dao.setName(EMPLOYEE_NAME);
        dao.setEmail(EMPLOYEE_EMAIL);

        EmployeeDTO expected = new EmployeeDTO();
        expected.setId(EMPLOYEE_ID);
        expected.setName(EMPLOYEE_NAME);
        expected.setEmail(EMPLOYEE_EMAIL);

        // WHEN

        EmployeeDTO actual = underTest.convert(dao);

        // THEN
        Assert.assertEquals(expected.getClass(), actual.getClass());
        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.getEmail(), actual.getEmail());

    }
}
