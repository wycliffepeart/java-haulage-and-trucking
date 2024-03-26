package org.jht.service;

import org.jht.dto.Address;
import org.jht.dto.Contact;
import org.jht.dto.Customer;

import java.util.Collections;
import java.util.List;

public class CustomerService {

    public List<Customer> getAll() {
        return Collections.nCopies(100, new Customer(
                1,
                "Active",
                "Wycliffe",
                "Peart",
                "123456789",
                "01/01/2024",
                new Contact(1, "345-545-5432", "y=mail@gmail.com"),
                new Address(1, "Digicel Group Limited", "14 Ocean Boulevard Kingston Jamaica", "Kingston", "Kingston P.O")
        ));
    }
}
