package org.jht.server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

@Getter()
@Setter()
@Entity
@Accessors(chain = true)
public class Salary {

    @Id
    @GeneratedValue
    private int id;

    private Date startDate;

    private Date endDate;

    private double salary;

    private Date createdAt;

    private Date updatedAt;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private Staff staff;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private Staff preparedBy;
}