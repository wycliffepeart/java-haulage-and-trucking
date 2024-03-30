package org.jht.server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Embeddable
class CourseRatingKey implements Serializable {

    @Column(name = "s_id")
    Long studentId;

    @Column(name = "course_id")
    Long courseId;

    // standard constructors, getters, and setters
    // hashcode and equals implementation
}

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

    @ManyToMany(cascade = CascadeType.ALL)
    private List<OrderEntity> orderEntities;

    @ManyToOne(cascade = CascadeType.ALL)
    private Staff staff;

    @ManyToOne(cascade = CascadeType.ALL)
    private Staff admin;
}