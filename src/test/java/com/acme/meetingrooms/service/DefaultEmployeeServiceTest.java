package com.acme.meetingrooms.service;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.convert.converter.Converter;

import com.acme.meetingrooms.dao.EmployeeDAO;
import com.acme.meetingrooms.dao.entity.EmployeeEntity;
import com.acme.meetingrooms.service.converter.EmployeeDAOToDTOConverter;
import com.acme.meetingrooms.service.dto.EmployeeDTO;

/**
 * asdf.
 * @author Istvan_Hever
 *
 */
public class DefaultEmployeeServiceTest {

    private EmployeeService underTest;
    private EmployeeDAO employeeDAO;
    private Converter<EmployeeEntity, EmployeeDTO> employeeConverter;

    @Before
    public void setUp() throws Exception {

        employeeDAO = EasyMock.createMock(EmployeeDAO.class);
        employeeConverter = EasyMock.createMock(EmployeeDAOToDTOConverter.class);

        underTest = new DefaultEmployeeService(employeeDAO, employeeConverter);
    }

    @Test
    public void testGetAllEmployeesShouldReturnEmptyList() {

        // GIVEN
        List<EmployeeEntity> emptyList = new ArrayList<EmployeeEntity>();
        List<EmployeeDTO> expected = new ArrayList<EmployeeDTO>();

        EasyMock.expect(employeeDAO.getAllEmployees()).andReturn(emptyList).times(1);
        EasyMock.replay(employeeDAO);

        // WHEN
        List<EmployeeDTO> actual = underTest.getAllEmployees();

        // THEN
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetAllEmployeesShouldReturnAListWithOneElement() {

        // GIVEN
        List<EmployeeEntity> oneElementList = new ArrayList<EmployeeEntity>();
        EmployeeEntity entity = EasyMock.createMock(EmployeeEntity.class);
        EasyMock.expect(entity.getId()).andReturn(5L).times(1);
        entity.setName("asdf");
        entity.setEmail("asdf@asdf.hu");
        oneElementList.add(entity);

        List<EmployeeDTO> expected = new ArrayList<EmployeeDTO>();
        EmployeeDTO dto = EasyMock.createMock(EmployeeDTO.class);
        dto.setId(5L);
        dto.setName("asdf");
        dto.setEmail("asdf@asdff.hu");

        EasyMock.expect(employeeDAO.getAllEmployees()).andReturn(oneElementList).times(1);
        EasyMock.replay(employeeDAO);

        // WHEN
        List<EmployeeDTO> actual = underTest.getAllEmployees();

        // THEN
        Assert.assertEquals(expected, actual);
    }

    //    public List<EmployeeDTO> getAllEmployees() {
    //        List<EmployeeEntity> rawEmployees = dao.getAllEmployees();
    //        List<EmployeeDTO> employees = new ArrayList<EmployeeDTO>();
    //        for (EmployeeEntity employeeEntity : rawEmployees) {
    //            employees.add(employeeDAOToDTOConverter.convert(employeeEntity));
    //            logger.debug("DES: " + employees.get(employees.size() - 1).getId());
    //        }
    //        return employees;
    //    }

    @Test
    public void testGetEmployees() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetEmployeeById() {
        fail("Not yet implemented");
    }

    @Test
    public void testAddEmployee() {
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

    @Test
    public void testRemoveEmployeeEmployeeDTO() {
        fail("Not yet implemented");
    }

    @Test
    public void testCountEmployees() {
        fail("Not yet implemented");
    }

}
