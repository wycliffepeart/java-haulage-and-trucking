package org.jht.service;

import org.jht.dto.Salary;
import org.jht.support.HttpClient;
import org.repository.SalaryRepository;
import retrofit2.Callback;

import java.io.IOException;
import java.util.List;

public class SalaryService {


    public List<Salary> getAll() {
        try {
            return HttpClient.use(SalaryRepository.class).getSalaries().execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void getAll(Callback<List<Salary>> callback) {
        HttpClient.use(SalaryRepository.class).getSalaries().enqueue(callback);
    }
}
