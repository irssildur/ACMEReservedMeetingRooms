package com.acme.meetingrooms.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

/**
 * Entity Class for Authority.
 * @author Istvan_Hever
 *
 */
@Data
@Entity
public class AuthorityEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String authority;

}
