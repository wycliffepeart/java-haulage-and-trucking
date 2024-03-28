package org.jht.server.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Entity
@Accessors(chain = true)
public class Address {

    @Id
    @GeneratedValue
    private long id;

    private String lineOne;

    private String lineTwo;

    private String parish;

    private String postOffice;
}
