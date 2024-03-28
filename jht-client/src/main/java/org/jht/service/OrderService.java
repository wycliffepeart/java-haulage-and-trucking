package org.jht.service;

import org.jht.dto.Order;
import org.jht.dto.OrderRequestBody;
import org.jht.support.HttpClient;
import org.repository.OrderRepository;
import retrofit2.Callback;

import java.util.List;

/**
 * The OrderService class provides methods to interact with the order API.
 */
public class OrderService {

    /**
     * Performs a GET request to retrieve a list of orders.
     *
     * @param callback the callback to be notified when the request is complete
     */
    public void get(Callback<List<Order>> callback) {
        HttpClient.use(OrderRepository.class).get().enqueue(callback);
    }

    /**
     * Performs a POST request to create a new order.
     *
     * @param order the order to be created
     * @param callback the callback to be notified when the request is complete
     */
    public void post(OrderRequestBody order, Callback<Order> callback) {
        HttpClient.use(OrderRepository.class).post(order).enqueue(callback);
    }
}
