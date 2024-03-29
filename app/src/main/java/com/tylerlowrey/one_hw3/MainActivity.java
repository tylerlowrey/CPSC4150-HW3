package com.tylerlowrey.one_hw3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

/**
 * Functionality: MainActivity hosts the fragments that drive this application. It determines when
 *                fragments are displayed, when they are replaced, and what to do when they are
 *                clicked on.
 *
 * Zybooks Reference: the setup and execution of FragmentTransactions found in each of the methods
 *                    below is modified from the Zybooks Ch5 Fragments - Figure 5.3.2 example.
 */
public class MainActivity extends AppCompatActivity implements CityListFragment.OnCitySelectedListener{
    private City currentCity;

    /**
     * Functionality: Determines orientation of application and inflates the proper fragment
     * PreConditions: none
     * PostConditions: Main Activity receives its layout file, and instructions on which fragments
     *                 to place inside of the frame layouts in main_activity.xml
     * Zybooks Reference: FragmentTransactions code was pulled and modified from Zybooks Figure 5.3.2
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Determine Orientation of application
        int orientation = getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_PORTRAIT)
        {   // Portrait Mode -> Only display CityListFragment
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            // Replace the contents of the container with the new fragment
            ft.replace(R.id.list_fragment_container, new CityListFragment());
            ft.commit();
        }
        else
        {   // Landscape Mode -> display both CityFragmentList and DetailsFragment
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            // Replace the contents of the container with the new fragment
            ft.replace(R.id.list_fragment_container, new CityListFragment());
            ft.replace(R.id.details_fragment_container, new DetailsFragment());
            ft.commit();
        }
    }   //end onCreate

    /**
     * Functionality: Determines which container to display the detailsFragment in
     * PreConditions: city must not be null
     * PostConditions: details fragment replaces either the list_fragment_container or the
     *                 details_fragment_container
     * Zybooks Reference: FragmentTransactions code was pulled and modified from Zybooks Figure 5.3.2
     */
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

    /**
     * Functionality: Returns the user to the CityListFragment to select a different city
     * PreConditions: View v must not be null, list_fragment_container must be inflated to the front
     *                of the screen
     * PostConditions: CityListFragment replaces the DetailsFragment in the list_fragment_container
     *                 from activity_main.xml
     * Zybooks Reference: FragmentTransactions code was pulled and modified from Zybooks Figure 5.3.2
     */
    public void backClicked(View v)
    {
        Fragment cityListFragment = CityListFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.list_fragment_container, cityListFragment)
                .commit();
    }   //end backClicked
}   //end MainActivity class
