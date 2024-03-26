package org.jht.service;

import org.jht.dto.Order;
import org.jht.support.HttpClient;
import org.repository.OrderRepository;
import retrofit2.Callback;

import java.io.IOException;
import java.util.List;

public class OrderService {

    public List<Order> getAll() {
        try {
            return HttpClient.use(OrderRepository.class).getOrders().execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getAll(Callback<List<Order>> callback) {
        HttpClient.use(OrderRepository.class).getOrders().enqueue(callback);
    }
}
