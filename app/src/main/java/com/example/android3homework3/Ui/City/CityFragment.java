package com.example.android3homework3.Ui.City;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.android3homework3.R;
import com.example.android3homework3.databinding.FragmentCityBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class CityFragment extends Fragment {

    private FragmentCityBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCityBinding.inflate(inflater,container,false);
        selectedItem();
        return binding.getRoot();
    }

    private void selectedItem() {
        binding.searchBtn.setOnClickListener(view -> {
            NavController controller = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
            controller.navigate(CityFragmentDirections.actionCityFragmentToWeatherFragment()
                    .setCityName(binding.nameCity.getText().toString()));
        });
    }
}