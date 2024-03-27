package org.jht.server.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Getter
@Setter
@Entity
@Accessors(chain = true)
public class OrderEntity {

    @Id
    @GeneratedValue
    private int id;

    private String invoiceNumber;

    private double rate;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt = new Date();

    @OneToOne(cascade = CascadeType.ALL)
    private Route route;

    @OneToOne(cascade = CascadeType.ALL)
    private Staff driver;

    @OneToOne(cascade = CascadeType.ALL)
    private Staff admin;

    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    private Address sourceAddress;

    @OneToOne(cascade = CascadeType.ALL)
    private Address destinationAddress;
}
