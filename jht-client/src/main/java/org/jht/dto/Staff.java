package org.jht.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.jht.support.Role;

@Getter()
@Setter()
@AllArgsConstructor
@Accessors(chain = true)
public class Staff {

    private final int id;
    private final String status;
    private final Role role;
    private final String firstName;
    private final String lastName;
    private final String dob;
    private final String trn;
    private final String nextOfKinFirstName;
    private final String nextOfKinLastName;
    private final String nextOfKinContactNumber;
    private final String createdAt;
    private final String updatedAt;
    private final Contact contact;
    private final Address address;
}
