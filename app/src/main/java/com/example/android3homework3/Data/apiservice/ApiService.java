package com.example.android3homework3.Data.apiservice;
import com.example.android3homework3.Models.WeatherModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("weather")
    Call<WeatherModel> getWeather(
            @Query("q") String q,
            @Query("appid") String appid,
            @Query("units") String units
    );
}
