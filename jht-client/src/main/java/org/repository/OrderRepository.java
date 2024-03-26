package org.repository;

import org.jht.dto.Order;
import org.jht.dto.Staff;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface OrderRepository {
    @GET("orders")
    Call<List<Order>> orderList();
}