package com.tylerlowrey.one_hw3;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class WeatherDetailsFragment extends Fragment {

    public WeatherDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Toast loadingWeatherToast = Toast.makeText(getContext(), "Grabbing Weather Data, One Moment Please", Toast.LENGTH_SHORT);
        loadingWeatherToast.show();

        Bundle args = getArguments();
        String cityName = args.getString("name");
        double cityLatitude = args.getDouble("latitude");
        double cityLongitude = args.getDouble("longitude");

        //TODO: Pull weather conditions from model
        //TODO: update Textviews in fragment_weather_details.xml

        //TODO: loadingWeatherToast.cancel()   <- check to see if this doesnt throw error

        return inflater.inflate(R.layout.fragment_weather_details, container, false);
    }
}
