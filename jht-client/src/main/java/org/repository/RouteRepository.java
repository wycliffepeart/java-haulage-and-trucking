package org.repository;

import org.jht.dto.Route;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface RouteRepository {

    @GET("routes")
    Call<List<Route>> getRoutes();
}
