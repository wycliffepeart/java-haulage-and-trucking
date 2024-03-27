package org.repository;

import org.jht.dto.Route;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

/**
 * RouteRepository is an interface used to interact with the route-related endpoints of the API.
 */
public interface RouteRepository {

    /**
     * This method communicates with the "routes" GET endpoint of the API.
     * It gets a list of all route objects present in the API database.
     *
     * @return Call<List<Route>> This returns a Call object which can contain a list of Route objects.
     */
    @GET("routes")
    Call<List<Route>> get();

    /**
     * This method communicates with the "routes" POST endpoint of the API.
     * It posts (i.e., writes/inserts) a Route object to the API database.
     *
     * @param route This is the route object that needs to be inserted in the API database.
     * @return Call<Route> This returns a Call object which can contain the inserted Route object.
     */
    @POST("routes")
    Call<Route> post(@Body Route route);
}
