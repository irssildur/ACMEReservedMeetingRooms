package com.acme.meetingrooms.service.builder;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test suite for the EmployeeBuilder tests.
 * @author Istvan_Hever
 *
 */
@RunWith(Suite.class)
@SuiteClasses(
        {EmployeeDAOBuilderTest.class,
            EmployeeDTOBuilderTest.class,
            EmployeeFormBuilderTest.class
        })
public class AllEmployeeBuilderTests {

}
