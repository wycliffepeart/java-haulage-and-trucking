package org.jht.server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Accessors(chain = true)
public class Customer {

    @Id
    @GeneratedValue
    private long id;
    private String status;

    private String companyName;

    private String contactPerson;

    private LocalDate createdAt;

    @OneToOne(cascade = CascadeType.ALL)
    private Contact contact;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}
