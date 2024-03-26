package org.repository;

import org.jht.dto.Customer;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface CustomerRepository{
    @GET("customers")
    Call<List<Customer>> customerList();
}