package com.acme.meetingrooms.service.converter;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.acme.meetingrooms.dao.entity.EmployeeEntity;
import com.acme.meetingrooms.service.dto.EmployeeDTO;

/** Test case for the EmployeeDTOToDAOConverter class.
 * @author Istvan_Hever
 *
 */
public class EmployeeDTOToDAOConverterTest {

    private static final long EMPLOYEE_ID = 4;
    private static final String EMPLOYEE_EMAIL = "email@email.com";
    private static final String EMPLOYEE_NAME = "asdf";
    private EmployeeDTOToDAOConverter underTest;

    /** Setting up the test.
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        underTest = new EmployeeDTOToDAOConverter();
    }

    /**
     * Test method for {@link com.acme.meetingrooms.service.converter.EmployeeDTOToDAOConverterTest#convert(com.acme.meetingrooms.service.dto.EmployeeDTO)}.
     */
    @Test
    public void testConvertShouldPass() {
        // GIVEN
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(EMPLOYEE_ID);
        dto.setName(EMPLOYEE_NAME);
        dto.setEmail(EMPLOYEE_EMAIL);

        EmployeeEntity expected = new EmployeeEntity();
        expected.setId(EMPLOYEE_ID);
        expected.setName(EMPLOYEE_NAME);
        expected.setEmail(EMPLOYEE_EMAIL);

        // WHEN
        EmployeeEntity actual = underTest.convert(dto);

        // THEN
        Assert.assertEquals(expected.getClass(), actual.getClass());
        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.getEmail(), actual.getEmail());
    }

}
