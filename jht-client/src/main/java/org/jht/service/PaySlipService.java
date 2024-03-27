package org.jht.service;

import org.jht.dto.PaySlip;
import org.jht.support.HttpClient;
import org.repository.PaySlipRepository;
import retrofit2.Callback;

import java.io.IOException;
import java.util.List;

public class PaySlipService {


    public List<PaySlip> getAll() {
        try {
            return HttpClient.use(PaySlipRepository.class).getSalaries().execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void getAll(Callback<List<PaySlip>> callback) {
        HttpClient.use(PaySlipRepository.class).getSalaries().enqueue(callback);
    }
}
