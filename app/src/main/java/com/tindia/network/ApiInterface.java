package com.tindia.network;


import com.tindia.model.AppBundle;
import com.tindia.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiInterface {
    @GET("films")
    Call<List<Movie>> getMovies();


    @GET("bundle")
    Call<AppBundle> getBundle();
}