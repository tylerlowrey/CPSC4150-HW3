package com.tylerlowrey.one_hw3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

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

        // Determine Orientation of application
        int orientation = getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_PORTRAIT)
        {   // Portrait Mode -> Only display City list

            // Begin the transaction
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            // Replace the contents of the container with the new fragment
            ft.replace(R.id.list_fragment_container, new CityListFragment());
            ft.commit();
        }
        else
        {
            // Begin the transaction
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            // Replace the contents of the container with the new fragment
            ft.replace(R.id.list_fragment_container, new CityListFragment());
            ft.replace(R.id.details_fragment_container, new DetailsFragment());
            ft.commit();
        }
    }   //end onCreate


    public void onCitySelected(City city) {
        currentCity = city;

        int orientation = getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            // Portrait Mode - replace current fragment with details fragment
            Fragment detailsFragment = DetailsFragment.newInstance(currentCity);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.list_fragment_container, detailsFragment)
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
            // Landscape mode - add fragment to details_fragment_container
            Fragment detailsFragment = DetailsFragment.newInstance(currentCity);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.details_fragment_container, detailsFragment)
                    .commit();
        }


    }   //end onCitySelected

    public void backClicked(View v)
    {
        Fragment cityListFragment = CityListFragment.newInstance(currentCity);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.list_fragment_container, cityListFragment)
                .commit();
    }
}   //end MainActivity class
