package com.example.arturmusayelyan.retrofitexample;

import com.example.arturmusayelyan.retrofitexample.models.Contacts;
import com.example.arturmusayelyan.retrofitexample.models.Example;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by artur.musayelyan on 12/02/2018.
 */

public interface ApiInterface {

    @GET("?action=categories")
    Call<List<Contacts>> getContacts();

    @GET("weather?id=616051&units=metric&APPID=06c0cd0ecefd895a9600f56949423d8e")
    Call<Example> getExample();
}
