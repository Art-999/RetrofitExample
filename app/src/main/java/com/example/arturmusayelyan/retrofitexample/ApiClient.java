package com.example.arturmusayelyan.retrofitexample;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by artur.musayelyan on 12/02/2018.
 */

public class ApiClient {
    public static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";

    private static Retrofit retrofit = null;

    public static Retrofit getApiClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
