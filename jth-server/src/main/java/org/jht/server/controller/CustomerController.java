package org.jht.server.controller;

import org.jht.server.entity.Customer;
import org.jht.server.repository.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping()
    ResponseEntity<Customer> post(@RequestBody Customer customer) {
        return ResponseEntity.ok(this.customerRepository.save(customer));
    }

    @GetMapping()
    ResponseEntity<List<Customer>> get() {
        return ResponseEntity.ok(this.customerRepository.findAll());
    }
}
