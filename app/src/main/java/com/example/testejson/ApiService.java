package com.example.testejson;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("teste.json")
    Call<List<RequestApi>> requestApi();

}