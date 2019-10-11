package com.tylerlowrey.one_hw3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements CityListFragment.OnCitySelectedListener{
    private City currentCity;

    /*
     * Functionality: Constructor
     * PreConditions:
     * PostConditions:
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }   //end onCreate


    public void onCitySelected(City city) {
        currentCity = city;

        //Bundle cityInfo = new Bundle();
        //cityInfo.putString("name", currentCity.getName());
        //cityInfo.putDouble("latitude", currentCity.getLatitude());
        //cityInfo.putDouble("longitude", currentCity.getLongitude());

        if (findViewById(R.id.details_fragment) == null)
        {

            Fragment detailsFragment = DetailsFragment.newInstance(currentCity);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.CityListFragment, detailsFragment)
                    .commit();
            /*
            Intent intent = new Intent(this, WeatherDetailsActivity.class);
            intent.putExtra("name", currentCity.getName());
            intent.putExtra("latitude", currentCity.getLatitude());
            intent.putExtra("longitude", currentCity.getLongitude());
            startActivity(intent);
             */
        }
        else
        {
            Fragment detailsFragment = DetailsFragment.newInstance(currentCity);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.details_fragment, detailsFragment)
                    .commit();
        }


    }
}   //end MainActivity class
