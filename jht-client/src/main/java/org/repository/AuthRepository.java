package org.repository;

import org.jht.dto.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthRepository {

    /**
     * Sends a POST request to the "auth" endpoint with the given User object as the request body.
     * This method is used for authenticating and retrieving user information.
     *
     * @param user The User object to be sent as the request body.
     * @return A Call object representing the asynchronous response of the POST request.
     */
    @POST("auth")
    Call<User> post(@Body User user);
}
