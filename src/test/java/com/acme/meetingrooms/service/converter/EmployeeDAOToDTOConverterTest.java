package com.acme.meetingrooms.service.converter;

import junit.framework.Assert;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.acme.meetingrooms.dao.entity.EmployeeEntity;
import com.acme.meetingrooms.service.builder.EmployeeBuilder;
import com.acme.meetingrooms.service.builder.EmployeeDTOBuilder;
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

        EmployeeBuilder<EmployeeDTO> builder = EasyMock.createMock(EmployeeDTOBuilder.class);
        EasyMock.expect(builder.withId(EMPLOYEE_ID)).andReturn(builder).times(1);
        EasyMock.expect(builder.withName(EMPLOYEE_NAME)).andReturn(builder).times(1);
        EasyMock.expect(builder.withEmail(EMPLOYEE_EMAIL)).andReturn(builder).times(1);
        EasyMock.expect(builder.build()).andReturn(expected);
        EasyMock.replay(builder);

        // WHEN

        underTest.setBuilder(builder);
        EmployeeDTO actual = underTest.convert(dao);

        // THEN

        Assert.assertEquals(EMPLOYEE_ID, actual.getId());
        Assert.assertEquals(EMPLOYEE_NAME, actual.getName());
        Assert.assertEquals(EMPLOYEE_EMAIL, actual.getEmail());

    }
}
