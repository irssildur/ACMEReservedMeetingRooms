package com.acme.meetingrooms.service.converter;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.acme.meetingrooms.controller.form.EmployeeForm;
import com.acme.meetingrooms.service.dto.EmployeeDTO;

/** Test case for the EmployeeFormToDTOConverter class.
 * @author Istvan_Hever
 *
 */
public class EmployeeFormToDTOConverterTest {

    private static final String EMPLOYEE_EMAIL = "email@email.com";
    private static final String EMPLOYEE_NAME = "asdf";
    private EmployeeFormToDTOConverter underTest;

    /** Setting up.
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        underTest = new EmployeeFormToDTOConverter();
    }

    /**
     * Test method for {@link com.acme.meetingrooms.service.converter.EmployeeFormToDTOConverter#convert(com.acme.meetingrooms.controller.form.EmployeeForm)}.
     */
    @Test
    public void testConvert() {
        // GIVEN
        EmployeeForm form = new EmployeeForm();
        form.setName(EMPLOYEE_NAME);
        form.setEmail(EMPLOYEE_EMAIL);

        EmployeeDTO expected = new EmployeeDTO();
        expected.setName(EMPLOYEE_NAME);
        expected.setEmail(EMPLOYEE_EMAIL);

        // WHEN
        EmployeeDTO actual = underTest.convert(form);

        // THEN
        Assert.assertEquals(expected.getClass(), actual.getClass());
        Assert.assertEquals(0, actual.getId());
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.getEmail(), actual.getEmail());
    }

}
