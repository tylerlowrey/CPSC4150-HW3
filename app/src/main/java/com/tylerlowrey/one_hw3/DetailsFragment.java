package com.tylerlowrey.one_hw3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class DetailsFragment extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState)
    {

        Toast loadingWeatherToast = Toast.makeText(getContext(), "Grabbing Weather Data, One Moment Please", Toast.LENGTH_SHORT);
        loadingWeatherToast.show();

        Bundle args = getArguments();

        //String cityName = args.getString("name");
        //double cityLatitude = args.getDouble("latitude");
        //double cityLongitude = args.getDouble("longitude");

        //TODO: Update the Details Fragment View

        //TODO: loadingWeatherToast.cancel()   <- check to see if this doesnt throw error

        return inflater.inflate(R.layout.fragment_details_land_test, container, false);
    }
}
