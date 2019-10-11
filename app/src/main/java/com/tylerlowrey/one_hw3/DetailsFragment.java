package com.tylerlowrey.one_hw3;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;

import static com.android.volley.VolleyLog.TAG;

public class DetailsFragment extends Fragment
{

    private ImageView weatherImageView;
    private TextView locationNameTextView;
    private TextView weatherDetailsTextView;
    private TextView precipitationDetailsTextView;
    private TextView temperatureDetailsTextView;

    public static DetailsFragment newInstance(City city)
    {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putString("name", city.getName());
        args.putDouble("latitude", city.getLatitude());
        args.putDouble("longitude", city.getLongitude());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState)
    {

        View view;

        int orientation = getActivity().getResources().getConfiguration().orientation;

        if(orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            view = inflater.inflate(R.layout.fragment_details, container, false);

        }
        else
        {
            view = inflater.inflate(R.layout.fragment_details_land, container, false);
        }

        weatherImageView = view.findViewById(R.id.details_weather_image);
        locationNameTextView = view.findViewById(R.id.details_location_name);
        weatherDetailsTextView = view.findViewById(R.id.details_weather_content);
        precipitationDetailsTextView = view.findViewById(R.id.details_precipitation_content);
        temperatureDetailsTextView = view.findViewById(R.id.details_temperature_content);

        final Toast loadingWeatherToast = Toast.makeText(getContext(), getString(R.string.weather_data_loading), Toast.LENGTH_SHORT);
        loadingWeatherToast.show();

        Intent intent = getActivity().getIntent();

        Bundle args = intent.getExtras();


        String cityName = "Charlotte";
        double cityLatitude = 35.227085;
        double cityLongitude = -80.843124;

        if(args != null)
        {
            cityName = args.getString("name", "Default");
            cityLatitude = args.getDouble("latitude");
            cityLongitude = args.getDouble("longitude");
        }
        else if (getArguments() != null)
        {
            args = getArguments();
            cityName = args.getString("name");
            cityLatitude = args.getDouble("latitude");
            cityLongitude = args.getDouble("longitude");
        }



        locationNameTextView.setText(cityName);

        String apiKey = "e6fc050255e1f924eae6e045faa9bc36";

        String darkSkyAPIURL = String.format(Locale.ENGLISH,
                "https://api.darksky.net/forecast/%s/%f,%f?exclude=minutely,hourly,daily,alerts&units=us",
                apiKey, cityLatitude, cityLongitude);

        // Create a new RequestQueue
        RequestQueue queue = Volley.newRequestQueue(getContext());

        // Create a new JsonObjectRequest that requests available subjects
        JsonObjectRequest requestObj = new JsonObjectRequest
                (Request.Method.GET, darkSkyAPIURL, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try
                        {
                            JSONObject currentWeather = response.getJSONObject("currently");
                            String currentWeatherSummary = currentWeather.getString("summary");
                            String currentWeatherPrecipitation = currentWeather.getString("precipProbability");
                            String currentTemperature = currentWeather.getString("temperature");
                            String iconType = currentWeather.getString("icon");

                            weatherDetailsTextView.setText(currentWeatherSummary);
                            precipitationDetailsTextView.setText(currentWeatherPrecipitation);
                            temperatureDetailsTextView.setText(currentTemperature + " " + getString(R.string.temperature_unit));

                            weatherImageView.setImageDrawable(getDrawableWeatherIcon(iconType));
                            //loadingWeatherToast.cancel();
                        }
                        catch (JSONException e)
                        {
                            final Toast loadingWeatherToast = Toast.makeText(getContext(),
                                    getString(R.string.weather_data_not_found), Toast.LENGTH_LONG);
                            loadingWeatherToast.show();
                            Log.e(TAG, "Bad JSON response: " + response.toString());
                        }



                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        final Toast loadingWeatherToast = Toast.makeText(getContext(),
                                getString(R.string.weather_data_not_found), Toast.LENGTH_LONG);
                        loadingWeatherToast.show();
                        Log.e(TAG, "Error: " + error.toString());
                    }
                });

        // Add the request to the RequestQueue
        queue.add(requestObj);



        return view;
    }

    /**
     * Returns a {@link android.graphics.drawable.Drawable} that corresponds to the weather icon string
     * that was passed in
     *
     * @param icon - The string name of the icon to be used. Should be a valid icon string as
     *             defined by the DarkSky documentation
     * @return - A Drawable representing the weather icon for the given input
     *
     * For valid input options @see <a href="https://darksky.net/dev/docs">Dark Sky Documentation</a>.
     * Icon strings can be found under Data Point Object at the icon parameter
     */
    private Drawable getDrawableWeatherIcon(String icon)
    {
        Context context = getContext();
        switch (icon)
        {
            case "clear-day":
                return ContextCompat.getDrawable(context, R.drawable.clear_day_weather_icon);
            case "clear-night":
                return ContextCompat.getDrawable(context, R.drawable.clear_night_weather_icon);
            case "rain":
                return ContextCompat.getDrawable(context, R.drawable.rainy_weather_icon);
            case "snow":
            case "sleet":
                return ContextCompat.getDrawable(context, R.drawable.snowy_weather_icon);
            case "wind":
                return ContextCompat.getDrawable(context, R.drawable.windy_weather_icon);
            case "fog":
            case "cloudy":
                return ContextCompat.getDrawable(context, R.drawable.cloudy_weather_icon);
            case "partly-cloudy-day":
                return ContextCompat.getDrawable(context, R.drawable.cloudy_day_weather_icon);
            case "partly-cloudy-night":
                return ContextCompat.getDrawable(context, R.drawable.clear_night_weather_icon);
            default:
                return ContextCompat.getDrawable(context, R.drawable.default_weather_icon);
        }
    }

}
