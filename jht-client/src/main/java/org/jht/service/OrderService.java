package org.jht.service;

import org.jht.dto.*;
import org.jht.support.Role;

import java.util.Collections;
import java.util.List;

public class OrderService {

    public List<Order> getAll() {
        var order = new Order()
                .setId(1)
                .setRate(12.4)
                .setInvoiceNumber("123456789")
                .setCustomer(new Customer(
                        1,
                        "Active",
                        "Wycliffe",
                        "Peart",
                        "123456789",
                        "01/01/2024",
                        new Contact(1, "345-545-5432", "y=mail@gmail.com"),
                        new Address(1, "Digicel Group Limited", "14 Ocean Boulevard Kingston Jamaica", "Kingston", "Kingston P.O")
                ))
                .setSourceAddress(new Address(1, "Digicel Group Limited", "14 Ocean Boulevard Kingston Jamaica", "Kingston", "Kingston P.O"))
                .setDestinationAddress(new Address(1, "Digicel Group Limited", "14 Ocean Boulevard Kingston Jamaica", "Kingston", "Kingston P.O"))
                .setAdmin(new Staff(
                        1,
                        "Active",
                        Role.ADMIN,
                        "Wycliffe",
                        "Peart",
                        "01/01/2024",
                        "123456789",
                        "John",
                        "Doe",
                        "234-434-4323",
                        "01/01/2024",
                        "01/01/2024",
                        new Contact(1, "345-545-5432", "y=mail@gmail.com"),
                        new Address(1, "Digicel Group Limited", "14 Ocean Boulevard Kingston Jamaica", "Kingston", "Kingston P.O")
                ))
                .setDriver(new Staff(
                        1,
                        "Active",
                        Role.ADMIN,
                        "Wycliffe",
                        "Peart",
                        "01/01/2024",
                        "123456789",
                        "John",
                        "Doe",
                        "234-434-4323",
                        "01/01/2024",
                        "01/01/2024",
                        new Contact(1, "345-545-5432", "y=mail@gmail.com"),
                        new Address(1, "Digicel Group Limited", "14 Ocean Boulevard Kingston Jamaica", "Kingston", "Kingston P.O")
                ))
                .setUpdatedAt("01/01/2024")
                .setCreatedAt("01/01/2023");
        return Collections.nCopies(100, order);
    }
}
