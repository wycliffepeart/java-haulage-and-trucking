package org.repository;

import org.jht.dto.Customer;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

/**
 * The `CustomerRepository` interface is used to interact with the APIs customer-related endpoints.
 */
public interface CustomerRepository {

    /**
     * The `get` method communicates with the "customers" GET endpoint of the API.
     * It retrieves a list of all Customer objects present in the APIs database.
     *
     * @return A Retrofit `Call` object representing the asynchronous request,
     * which will retrieve a list of all Customers.
     */
    @GET("customers")
    Call<List<Customer>> get();

    /**
     * The `post` method communicates with the "customers" POST endpoint of the API.
     * It posts a Customer object to the APIs database.
     *
     * @param customer The Customer object that needs to be inserted in the APIs database.
     * @return A Retrofit `Call` object representing the asynchronous request,
     * which will post the Customer object.
     */
    @POST("customers")
    Call<Customer> post(@Body Customer customer);
}