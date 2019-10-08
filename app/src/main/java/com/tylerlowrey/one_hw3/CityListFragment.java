package com.tylerlowrey.one_hw3;

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


public class CityListFragment extends Fragment {

    public CityListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_city_list, container, false);
        ArrayList<City> cityList = City.createCityList();

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        CityAdapter adapter = new CityAdapter(cityList);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private class CityHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private City currentCity;
        private TextView cityTextView;

        public CityHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_city, parent, false));
            itemView.setOnClickListener(this);
            cityTextView = itemView.findViewById(R.id.list_item_text);
        }

        public void bind(City city) {
            currentCity = city;
            cityTextView.setText(currentCity.getName());
        }

        @Override
        public void onClick(View view) {
            // Tell ListActivity what band was clicked
            Bundle cityInfo = new Bundle();
            cityInfo.putString("name", currentCity.getName());
            /*
            cityInfo.putDouble("latitude", currentCity.getLatitude());
            cityInfo.putDouble("longitude", currentCity.getLongitude());
             */

            //TODO: create intent and send to weather details activity
        }
    }

    private class CityAdapter extends RecyclerView.Adapter<CityHolder> {
        private List<City> cities;
        public CityAdapter(List<City> myCities) {
            cities = myCities;
        }

        @Override
        public CityHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new CityHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(CityHolder holder, int position) {
            City city = cities.get(position);
            holder.bind(city);
        }

        @Override
        public int getItemCount() {
            return cities.size();
        }
    }   //end CityAdapter class

}
