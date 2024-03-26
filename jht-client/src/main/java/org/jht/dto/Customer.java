package org.jht.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter()
@Setter()
@AllArgsConstructor
@Accessors(chain = true)
public class Customer {
    private final int id;
    private final String status;
    private final String companyName;
    private final String contactPerson;
    private final String createdAt;
    private final String updatedAt;
    private final Contact contact;
    private final Address address;
}
