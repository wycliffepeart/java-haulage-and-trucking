package org.repository;

import org.jht.dto.Order;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface OrderRepository {
    @GET("orders")
    Call<List<Order>> getOrders();
}