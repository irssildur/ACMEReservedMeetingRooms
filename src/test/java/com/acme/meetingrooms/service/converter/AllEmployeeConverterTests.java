package com.acme.meetingrooms.service.converter;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test suite for the Employee Converters.
 * @author Istvan_Hever
 *
 */
@RunWith(Suite.class)
@SuiteClasses(
        {EmployeeDAOToDTOConverterTest.class,
            EmployeeDTOToDAOConverterTest.class,
            EmployeeFormToDTOConverterTest.class
        })
public class AllEmployeeConverterTests {

}
