package com.example.android3homework3.Data.repositories;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.example.android3homework3.Data.apiservice.ApiService;
import com.example.android3homework3.Models.WeatherModel;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class WeatherRepositories {

    private ApiService apiService;

    String apiKey = "d4a8ca3d48c72e937ac57126106e5eb5";
    String units = "metric";

    @Inject
    public WeatherRepositories(ApiService apiService) {
        this.apiService = apiService;
    }

    public MutableLiveData<WeatherModel> getWeather(String city) {
        MutableLiveData<WeatherModel> data = new MutableLiveData<>();
        apiService.getWeather(city, apiKey, units).enqueue(new Callback<WeatherModel>() {
            @Override
            public void onResponse(@NonNull Call<WeatherModel> call, @NonNull Response<WeatherModel> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<WeatherModel> call, @NonNull Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}
