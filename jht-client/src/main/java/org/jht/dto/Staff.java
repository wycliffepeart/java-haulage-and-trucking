package org.jht.dto;

import lombok.*;
import lombok.experimental.Accessors;
import org.jht.support.Role;

@Getter()
@Setter()
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Staff {

    private int id;
    private String status;
    private Role role;
    private String firstName;
    private String lastName;
    private String dob;
    private String trn;
    private String nextOfKinFirstName;
    private String nextOfKinLastName;
    private String nextOfKinContactNumber;
    private String createdAt;
    private String updatedAt;
    private Contact contact;
    private Address address;
}
