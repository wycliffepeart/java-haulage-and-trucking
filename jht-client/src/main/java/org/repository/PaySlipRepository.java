package org.repository;

import org.jht.dto.PaySlip;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface PaySlipRepository {

    @GET("salaries")
    Call<List<PaySlip>> getSalaries();
}
