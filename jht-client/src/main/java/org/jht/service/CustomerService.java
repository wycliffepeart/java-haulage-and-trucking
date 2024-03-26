package org.jht.service;

import org.jht.dto.Customer;
import org.jht.support.HttpClient;
import org.repository.CustomerRepository;

import java.io.IOException;
import java.util.List;

public class CustomerService {

    public List<Customer> getAll() {

        try {
            return HttpClient.use(CustomerRepository.class).customerList().execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
