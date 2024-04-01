package org.jht.service;

import org.jht.dto.Invoice;
import org.jht.support.HttpClient;
import org.repository.InvoiceRepository;
import retrofit2.Callback;

import java.util.List;
import java.util.Map;

public class InvoiceService {

    public void get(Callback<List<Invoice>> callback){
        HttpClient.use(InvoiceRepository.class).get().enqueue(callback);
    }

    public void filter(Map<String, String> queryMap,  Callback<List<Invoice>> callback){
        HttpClient.use(InvoiceRepository.class).filter(queryMap).enqueue(callback);
    }
}
