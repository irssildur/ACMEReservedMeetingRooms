package com.acme.meetingrooms.service.converter;

import junit.framework.Assert;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.acme.meetingrooms.controller.form.EmployeeForm;
import com.acme.meetingrooms.service.builder.EmployeeBuilder;
import com.acme.meetingrooms.service.builder.EmployeeDTOBuilder;
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

        EmployeeBuilder<EmployeeDTO> builder = EasyMock.createMock(EmployeeDTOBuilder.class);
        EasyMock.expect(builder.withName(EMPLOYEE_NAME)).andReturn(builder).times(1);
        EasyMock.expect(builder.withEmail(EMPLOYEE_EMAIL)).andReturn(builder).times(1);
        EasyMock.expect(builder.build()).andReturn(expected);
        EasyMock.replay(builder);
        // WHEN
        underTest.setBuilder(builder);
        EmployeeDTO actual = underTest.convert(form);
        // THEN
        Assert.assertEquals(0, actual.getId());
        Assert.assertEquals(EMPLOYEE_NAME, actual.getName());
        Assert.assertEquals(EMPLOYEE_EMAIL, actual.getEmail());
    }

}
