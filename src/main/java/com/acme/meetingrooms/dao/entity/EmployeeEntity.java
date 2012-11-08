package com.acme.meetingrooms.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Employee class representing an employee.
 * @author Istvan_Hever
 *
 */

@Data
@Entity
@Table(name = "employee")
public class EmployeeEntity {

    @GeneratedValue
    @Id
    private long id;

    private String name = "";
    private String email = "";

}
