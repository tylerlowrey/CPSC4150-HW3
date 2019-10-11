package com.tylerlowrey.one_hw3;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/**
 * Functionality: Displays a list of cities that the user can interact with to get weather data.
 */
public class CityListFragment extends Fragment {

    /**
     * Functionality: Required empty public constructor
     * PreConditions: None
     * PostConditions: CityListFragment is constructed
     */
    public CityListFragment() { }

    /**
     * Functionality:
     * PreConditions:
     * PostConditions:
     */
    public static CityListFragment newInstance() { return new CityListFragment(); }

    /**
     * Functionality:
     * PreConditions:
     * PostConditions:
     */
    // For the activity to implement
    public interface OnCitySelectedListener {
        void onCitySelected(City city);
    }

    /**
     * Functionality:
     * PreConditions:
     * PostConditions:
     */
    // Reference to the activity
    private OnCitySelectedListener mListener;

    /**
     * Functionality:
     * PreConditions:
     * PostConditions:
     */
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

    /**
     * Functionality:
     * PreConditions:
     * PostConditions:
     */
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
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

    /**
     * Functionality:
     */
    private class CityHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private City currentCity;
        private TextView citySelected;

        /**
         * Functionality: constructor for the CityHolder class
         * PreConditions:
         * PostConditions:
         */
        public CityHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_city, parent, false));
            itemView.setOnClickListener(this);
            citySelected = itemView.findViewById(R.id.list_item_text);
        }   // end CityHolder constructor

        /**
         * Functionality: Updates the local currentCity variable to the passed in city variable
         * PreConditions: city must be initialized and city.getName() != null
         * PostConditions: citySelected.getText() == city.getName()
         */
        public void bind(City city) {
            currentCity = city;
            citySelected.setText(currentCity.getName());
        }   //end bind

        /**
         * Functionality: Calls the onCitySelected function of all observers when the CityHolder is clicked
         * PreConditions: mListener must be initialized
         * PostConditions: All observers of mListener will have their onCitySelected function called
         */
        @Override
        public void onClick(View view) {
            mListener.onCitySelected(currentCity);
        }   //end onClick
    }   //end City Holder Class

    /**
     * Functionality: Serves as an Adapter for a RecyclerView
     */
    private class CityAdapter extends RecyclerView.Adapter<CityHolder> {
        private List<City> cities;

        /**
         * Functionality: Constructor
         * PreConditions: myCities should be a valid List<City> where myCities.size() > 0
         * PostConditions: this.cities = myCities
         */
        public CityAdapter(List<City> myCities) { cities = myCities; }

        /**
         * Functionality: Creates a {@link CityListFragment.CityHolder} and returns it.
         * PreConditions: parent must be a valid instantiated {@link ViewGroup} object
         * PostConditions: a valid CityHolder object will be returned
         */
        @Override
        public CityHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new CityHolder(layoutInflater, parent);
        }   //end onCreateViewHolder

        /**
         * Functionality: Calls the bind function of the given{@link CityListFragment.CityHolder},
         *                passing in the {@link City} that corresponds to the given position
         * PreConditions: this.cities should be initialized and position < cities.size(), holder
         *                should be an initialized CityHolder object
         * PostConditions: holder.bind() will be called with a valid City object
         */
        @Override
        public void onBindViewHolder(CityHolder holder, int position) {
            City city = cities.get(position);
            holder.bind(city);
        }   //end onBindViewHolder

        /**
         * Functionality: Returns the number of cities in the recyclerview
         * PreConditions: this.cities should be initialized
         * PostConditions: getItemCount() = cities.size()
         */
        @Override
        public int getItemCount() {
            return cities.size();
        }   //end getItemCount
    }   //end CityAdapter class
}   //end CityListFragment class
