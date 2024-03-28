package org.jht.server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.jht.server.support.Role;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Accessors(chain = true)
public class Staff {

    @Id
    @GeneratedValue
    private long id;

    private String status;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String firstName;

    private String lastName;

    private LocalDate dob;

    private String trn;

    private String nextOfKinFirstName;

    private String nextOfKinLastName;

    private String nextOfKinContactNumber;

    private LocalDate createdAt;

    @OneToOne(cascade = CascadeType.ALL)
    private Contact contact;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}
