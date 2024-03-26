package org.jht.service;

import org.jht.dto.Customer;
import org.jht.support.HttpClient;
import org.repository.CustomerRepository;
import retrofit2.Callback;

import java.io.IOException;
import java.util.List;

public class CustomerService {

    public List<Customer> getAll() {

        try {
            return HttpClient.use(CustomerRepository.class).getCustomers().execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getAll(Callback<List<Customer>> callback) {
        HttpClient.use(CustomerRepository.class).getCustomers().enqueue(callback);
    }
}
