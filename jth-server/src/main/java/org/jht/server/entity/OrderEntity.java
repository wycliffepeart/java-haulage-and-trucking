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
public class OrderEntity {

    @Id
    @GeneratedValue
    private long id;

    private String invoiceNumber;

    private LocalDate createdAt;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Route route;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Staff driver;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Staff admin;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Customer customer;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Address sourceAddress;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Address destinationAddress;
}
