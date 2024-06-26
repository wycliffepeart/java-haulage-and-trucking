package org.jht.support;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class HttpClient {

    public static <T> T use(final Class<T> repository) {

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/api/v1/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(repository);
    }
}

