package org.jht.support;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpClient {

    public static <T> T use(final Class<T> repository) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(repository);
    }
}
