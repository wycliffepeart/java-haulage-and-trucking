package org.jht.dto;


import lombok.*;
import lombok.experimental.Accessors;

@Getter()
@Setter()
@Accessors(chain = true)
public class Order {
    private int id;
    private String invoiceNumber;
    private String createdAt;
    private String updatedAt;
    private Route route;
    private Staff driver;
    private Staff admin;
    private Customer customer;
    private Address sourceAddress;
    private Address destinationAddress;
}
