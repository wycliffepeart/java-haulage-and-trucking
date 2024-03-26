package org.jht.service;

import org.jht.dto.*;
import org.jht.support.HttpClient;
import org.jht.support.Role;
import org.repository.OrderRepository;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class OrderService {

    public List<Order> getAll() {
        try {
            return HttpClient.use(OrderRepository.class).orderList().execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
