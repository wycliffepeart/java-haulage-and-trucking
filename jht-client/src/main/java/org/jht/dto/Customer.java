package org.jht.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter()
@Setter()
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Customer {
    private int id;
    private String status;
    private String companyName;
    private String contactPerson;
    private String nextOfKinFirstName;
    private String nextOfKinLastName;
    private String nextOfKinContactNumber;
    private String createdAt;
    private String updatedAt;
    private Contact contact;
    private Address address;
}
