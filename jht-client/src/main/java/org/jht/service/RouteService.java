package org.jht.service;

import org.jht.dto.Route;
import org.jht.support.HttpClient;
import org.repository.RouteRepository;
import retrofit2.Callback;

import java.io.IOException;
import java.util.List;

public class RouteService {

    public List<Route> getAll(){

        try {
            return HttpClient.use(RouteRepository.class).getRoutes().execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getAll(Callback<List<Route>> callback){
        HttpClient.use(RouteRepository.class).getRoutes().enqueue(callback);
    }
}
