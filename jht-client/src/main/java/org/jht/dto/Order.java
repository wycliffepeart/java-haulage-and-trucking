package org.jht.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter()
@Setter()
@AllArgsConstructor
@RequiredArgsConstructor
@Accessors(chain = true)
public class Order {
    private int id;
    private String invoiceNumber;
    private Double rate;
    private String createdAt;
    private String updatedAt;
    private Staff driver;
    private Staff admin;
    private Customer customer;
    private Address sourceAddress;
    private Address destinationAddress;
}
