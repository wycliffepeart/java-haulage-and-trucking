package org.jht.server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Accessors(chain = true)
public class Salary {

    @Id
    @GeneratedValue
    private long id;

    private double salary;

    private LocalDate startDate;

    private LocalDate endDate;

    private LocalDate createdAt;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderEntity> orderEntities;

    @OneToOne(cascade = CascadeType.ALL)
    private Staff staff;

    @OneToOne(cascade = CascadeType.ALL)
    private Staff admin;
}