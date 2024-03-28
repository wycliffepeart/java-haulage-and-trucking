package org.repository;

import org.jht.dto.GeneratePaySlipBody;
import org.jht.dto.PaySlip;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

/**
 * The PaySlipRepository interface is used to interact with the salary-related endpoints of the API.
 */
public interface PaySlipRepository {

    /**
     * The `get` method interacts with the 'salaries' GET endpoint of the API. It retrieves a list
     * of all PaySlip objects present in the API's database.
     *
     * @return A Retrofit `Call` object representing the asynchronous request,
     * which will retrieve a list of all PaySlips.
     */
    @GET("salaries")
    Call<List<PaySlip>> get();

    /**
     * The `post` method communicates with the "salaries" POST endpoint of the API.
     * It posts a PaySlip object to the API's database.
     *
     * @param paySlip The PaySlip object that needs to be inserted in the API's database.
     * @return A Retrofit `Call` object representing the asynchronous request,
     * which will post the PaySlip object.
     */
    @POST("salaries")
    Call<PaySlip> post(@Body GeneratePaySlipBody paySlip);
}
