package com.example.arturmusayelyan.retrofitexample;

import com.example.arturmusayelyan.retrofitexample.models.Contacts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by artur.musayelyan on 12/02/2018.
 */

public interface ApiInterface {

    @GET("?action=categories")
    Call<List<Contacts>> getContacts();
}
