package org.jht.server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Accessors(chain = true)
public class Invoice {

    @Id
    @GeneratedValue
    private long id;

    private double total;

    private LocalDate createdAt;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Customer customer;
}
