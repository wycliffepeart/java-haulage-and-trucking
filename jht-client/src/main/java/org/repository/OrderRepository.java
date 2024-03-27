package org.repository;

import org.jht.dto.Order;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

/**
 * The OrderRepository interface provides methods to interact with the order-related endpoints of the API.
 */
public interface OrderRepository {

    /**
     * The get() method communicates with the "orders" GET endpoint of the API.
     * It retrieves a list of all Order objects present in the API's database.
     *
     * @return A Retrofit Call object representing the asynchronous request,
     * which will retrieve a list of all Orders.
     */
    @GET("orders")
    Call<List<Order>> get();

    /**
     * The post() method communicates with the "orders" POST endpoint of the API.
     * It posts (i.e., writes/inserts) an Order object to the API's database.
     *
     * @param order The Order object that needs to be inserted in the API's database.
     * @return A Retrofit Call object representing the asynchronous request,
     * which will post the Order object.
     */
    @POST("orders")
    Call<Order> post(@Body Order order);
}