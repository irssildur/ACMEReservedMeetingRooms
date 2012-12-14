package com.acme.meetingrooms.dao.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
