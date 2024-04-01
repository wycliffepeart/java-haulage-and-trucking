package org.repository;

import org.jht.dto.Invoice;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

import java.util.List;
import java.util.Map;

public interface InvoiceRepository {

    @GET("invoices")
    Call<List<Invoice>> get();

    @GET("invoices/filter")
    Call<List<Invoice>> filter(@QueryMap Map<String, String> options);
}
