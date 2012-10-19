package com.acme.meetingrooms.service.builder;

import com.acme.meetingrooms.controller.form.EmployeeForm;

/** Concrete implementation of the interface EmployeeBuilder with a type EmployeeForm.
 * @author Istvan_Hever
 *
 */
public final class EmployeeFormBuilder implements EmployeeBuilder<EmployeeForm> {

    private EmployeeForm form;

    /**
     * Constructor.
     */
    private EmployeeFormBuilder() {
        form = new EmployeeForm();
    }

    @Override
    public EmployeeBuilder<EmployeeForm> getBuilder() {
        return new EmployeeFormBuilder();
    }

    @Override
    public EmployeeBuilder<EmployeeForm> withId(long id) {
        return this;
    }

    @Override
    public EmployeeBuilder<EmployeeForm> withName(String name) {
        form.setName(name);
        return this;
    }

    @Override
    public EmployeeBuilder<EmployeeForm> withEmail(String email) {
        form.setEmail(email);
        return this;
    }

    @Override
    public EmployeeForm build() {
        return form;
    }

}
