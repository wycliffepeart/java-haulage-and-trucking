package org.jht.server.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Accessors(chain = true)
public class Route {

    @Id
    @GeneratedValue
    private long id;

    private String route;

    private int distance;

    private double rate;

    private String description;

    private LocalDate createdAt;

}
