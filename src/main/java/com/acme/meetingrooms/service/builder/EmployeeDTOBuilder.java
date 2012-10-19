package com.acme.meetingrooms.service.builder;

import com.acme.meetingrooms.service.dto.EmployeeDTO;

/**
 * Concrete implementation of the interface EmployeeBuilder with a type EmployeeDTO.
 * @author Istvan_Hever
 *
 */
public final class EmployeeDTOBuilder implements EmployeeBuilder<EmployeeDTO> {

    private EmployeeDTO dto;

    /**
     * Constructor. Creates a new EmployeeDTO instance.
     */
    private EmployeeDTOBuilder() {
        dto = new EmployeeDTO();
    }

    @Override
    public EmployeeBuilder<EmployeeDTO> getBuilder() {
        return new EmployeeDTOBuilder();
    }

    @Override
    public EmployeeBuilder<EmployeeDTO> withId(long id) {
        dto.setId(id);
        return this;
    }

    @Override
    public EmployeeBuilder<EmployeeDTO> withName(String name) {
        dto.setName(name);
        return this;
    }

    @Override
    public EmployeeBuilder<EmployeeDTO> withEmail(String email) {
        dto.setEmail(email);
        return this;
    }

    @Override
    public EmployeeDTO build() {
        return dto;
    }

}
