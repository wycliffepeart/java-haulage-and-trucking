package org.jht.server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Entity
@Table(name = "user_entity")
@Accessors(chain = true)
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true)
    private String email;

    private String password;

    @ManyToOne(cascade = CascadeType.ALL)
    private Staff staff;
}
