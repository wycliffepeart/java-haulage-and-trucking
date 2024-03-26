package org.repository;

import org.jht.dto.Customer;
import org.jht.dto.Staff;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface StaffRepository {
    @GET("staffs")
    Call<List<Staff>> staffList();
}