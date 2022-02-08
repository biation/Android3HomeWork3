package com.example.android3homework3.Ui.Weather;

import androidx.lifecycle.MutableLiveData;

import com.example.android3homework3.Base.BaseViewModel;
import com.example.android3homework3.Data.repositories.WeatherRepositories;
import com.example.android3homework3.Models.WeatherModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class WeatherViewModel extends BaseViewModel {

    String city = "Bishkek";
    private WeatherRepositories repository;

    @Inject
    public WeatherViewModel(WeatherRepositories repository) {
        this.repository = repository;
    }

   MutableLiveData<WeatherModel> getWeather(String city) {
        return repository.getWeather(city);
    }
}
