package de.muenchen.service.domain

import org.hibernate.annotations.GenericGenerator

import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass

/**
 * Created by dennis_huning on 05.01.16.
 */
@MappedSuperclass
class BaseEntity {

    @Column(name = "OID")
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    UUID oid;

    @Column(length = 30, unique = true, nullable = true, name = "mandant")
    String mandant;
}
