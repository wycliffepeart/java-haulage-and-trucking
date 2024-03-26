package org.repository;

import org.jht.dto.Salary;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface SalaryRepository {

    @GET("salaries")
    Call<List<Salary>> getSalaries();
}
