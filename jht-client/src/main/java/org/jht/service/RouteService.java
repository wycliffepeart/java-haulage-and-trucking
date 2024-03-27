package org.jht.service;

import org.jht.dto.Route;
import org.jht.support.HttpClient;
import org.repository.RouteRepository;
import retrofit2.Callback;

import java.util.List;

/**
 * RouteService is a class that provides methods for retrieving routes.
 */
public class RouteService {

    /**
     * Retrieves all routes asynchronously.
     *
     * @param callback a callback that will be invoked with the retrieved routes
     */
    public void get(Callback<List<Route>> callback){
        HttpClient.use(RouteRepository.class).get().enqueue(callback);
    }

    /**
     * Sends a POST request to the specified route using the provided callback.
     *
     * @param route the Route object containing the route to be posted
     * @param callback the callback to be invoked with the response
     */
    public void post(Route route, Callback<Route> callback){
        HttpClient.use(RouteRepository.class).post(route).enqueue(callback);
    }
}
