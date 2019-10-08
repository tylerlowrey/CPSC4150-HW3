package com.tylerlowrey.one_hw3;

import java.util.ArrayList;

public class City {
    private String name;
    private String weatherCondition;
    private int temperature;
    private double latitude;
    private double longitude;


    // Constructors
    public City (String cityName){
        name = cityName;
        weatherCondition = "unknown";
        temperature = 100;
    }   //end of constructor
    public City (String cityName, String currentWeatherCondition, int currentTemp){
        name = cityName;
        weatherCondition = currentWeatherCondition;
        temperature = currentTemp;
    }   //end of constructor

    // --------------------- Getters and Setters for class private variables ----------------//
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getTemperature() { return temperature; }
    public void setTemperature(int temperature) { this.temperature = temperature; }
    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }
    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }
    public String getWeatherCondition() { return weatherCondition; }
    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }   // End of Getters and Setters

    // Creates list of cities and returns them to the fragment for display
    public static ArrayList<City> createCityList(){

        // Create instances of cities in ArrayList container
        ArrayList<City> cityList = new ArrayList<>();

        //TODO: Add latitude and Longitude to cities
        City clemson = new City("Clemson");
        City greenville = new City("Greenville");
        City charlotte = new City("Charlotte");
        City spartanburg = new City("Spartanburg");
        City anderson = new City("Anderson");
        City new_york = new City("New York");
        City washington_dc = new City("Washington D.C.");
        City san_diego = new City("San Diego");
        City columbia = new City("Columbia");
        City charleston = new City("Charleston");

        // Add cities to container
        cityList.add(clemson);
        cityList.add(greenville);
        cityList.add(charlotte);
        cityList.add(spartanburg);
        cityList.add(anderson);
        cityList.add(new_york);
        cityList.add(washington_dc);
        cityList.add(san_diego);
        cityList.add(columbia);
        cityList.add(charleston);
        return cityList;
    }   //end createCityList
}   //end City class
