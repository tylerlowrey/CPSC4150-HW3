package com.tylerlowrey.one_hw3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class CityListFragment extends Fragment {

    /*
     * Functionality: Required empty public constructor
     * PreConditions: None
     * PostConditions: None
     */
    public CityListFragment() { }

    public static CityListFragment newInstance(City city)
    {
        return new CityListFragment();
    }


    // For the activity to implement
    public interface OnCitySelectedListener {
        void onCitySelected(City city);
    }

    // Reference to the activity
    private OnCitySelectedListener mListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnCitySelectedListener) {
            mListener = (OnCitySelectedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnBandSelectedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /*
     * Functionality:
     * PreConditions:
     * PostConditions:
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_city_list, container, false);
        ArrayList<City> cityList = City.createCityList();

        // set up recycleview
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // set up recycleview adapter
        CityAdapter adapter = new CityAdapter(cityList);
        recyclerView.setAdapter(adapter);
        return view;
    }   //end onCreateView

    /*
     * Functionality:
     * PreConditions:
     * PostConditions:
     */
    private class CityHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private City currentCity;
        private TextView citySelected;

        /*
         * Functionality: constructor for the CityHolder class
         * PreConditions:
         * PostConditions:
         */
        public CityHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_city, parent, false));
            itemView.setOnClickListener(this);
            citySelected = itemView.findViewById(R.id.list_item_text);
        }   // end CityHolder constructor

        /*
         * Functionality:
         * PreConditions:
         * PostConditions:
         */
        public void bind(City city) {
            currentCity = city;
            citySelected.setText(currentCity.getName());
        }   //end bind

        /*
         * Functionality:
         * PreConditions:
         * PostConditions:
         */
        @Override
        public void onClick(View view) {
            mListener.onCitySelected(currentCity);
        }   //end onClick
    }   //end City Holder Class

    /*
     * Functionality:
     * PreConditions:
     * PostConditions:
     */
    private class CityAdapter extends RecyclerView.Adapter<CityHolder> {
        private List<City> cities;

        /*
         * Functionality: Constructor
         * PreConditions:
         * PostConditions:
         */
        public CityAdapter(List<City> myCities) { cities = myCities; }

        /*
         * Functionality:
         * PreConditions:
         * PostConditions:
         */
        @Override
        public CityHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new CityHolder(layoutInflater, parent);
        }   //end onCreateViewHolder

        /*
         * Functionality:
         * PreConditions:
         * PostConditions:
         */

        /* Could be a problem here that we are using int position rather than a name to access a city */
        @Override
        public void onBindViewHolder(CityHolder holder, int position) {
            City city = cities.get(position);
            holder.bind(city);
        }   //end onBindViewHolder

        /*
         * Functionality: Returns the number of cities in the recyclerview
         * PreConditions:
         * PostConditions:
         */
        @Override
        public int getItemCount() {
            return cities.size();
        }   //end getItemCount
    }   //end CityAdapter class
}   //end CityListFragment class
