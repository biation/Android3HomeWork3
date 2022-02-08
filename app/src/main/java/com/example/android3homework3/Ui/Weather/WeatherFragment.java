package com.example.android3homework3.Ui.Weather;

import android.os.Build;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.android3homework3.Base.BaseFragment;
import com.example.android3homework3.R;
import com.example.android3homework3.databinding.FragmentWeatherBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class WeatherFragment extends BaseFragment<WeatherViewModel, FragmentWeatherBinding> {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWeatherBinding.inflate(inflater,container,false);
        fragmentCity();
        return binding.getRoot();
    }

    private void fragmentCity() {
        binding.location.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
            navController.navigate(R.id.action_weatherFragment_to_cityFragment);
        });
    }

    @Override
    protected void initialize() {
        viewModel = new ViewModelProvider(requireActivity()).get(WeatherViewModel.class);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void setUpObserves() {
        viewModel.getWeather(WeatherFragmentArgs.fromBundle(getArguments()).getCityName()).observe(getViewLifecycleOwner(),weatherModel -> {
            binding.maxTemperature.setText(String.valueOf(weatherModel.getMain().getTempMax()));
            binding.cityTv.setText(weatherModel.getName());
            binding.minTemperature.setText(String.valueOf(weatherModel.getMain().getTempMin()));
            binding.humidityTv.setText(String.valueOf(weatherModel.getMain().getHumidity()));
            binding.pressureTv.setText(String.valueOf(weatherModel.getMain().getPressure()));
            binding.temperatureTv.setText(String.valueOf(weatherModel.getCoord().getLat()));
            binding.sunriseTv.setText(String.valueOf(weatherModel.getSys().getSunrise()));
            binding.sunsetTv.setText(String.valueOf(weatherModel.getSys().getSunset()));
            binding.speedTv.setText(String.valueOf(weatherModel.getWind().getSpeed()));
            binding.cloudTv.setText(String.valueOf(weatherModel.getClouds().getAll()));
        });
    }
}