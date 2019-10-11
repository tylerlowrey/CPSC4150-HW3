package com.tylerlowrey.one_hw3;

import java.util.ArrayList;

public class City {
    private String name;
    private String weatherCondition;
    private int temperature;
    private double latitude;
    private double longitude;


    /*
     * Functionality: Constructor with arguements to create City with values
     * PreConditions:
     * PostConditions:
     */
    public City (String cityName, double latitude, double longitude){
        name = cityName;
        weatherCondition = "unknown";
        temperature = 1000;
        this.latitude = latitude;
        this.longitude = longitude;
    }   //end of constructor


    // --------------------- Getters and Setters for class private variables ----------------//
    /*
     * Functionality:
     * PreConditions:
     * PostConditions:
     */
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

    /*
     * Functionality: Creates list of cities and returns them to the fragment for display
     * PreConditions:
     * PostConditions:
     */
    public static ArrayList<City> createCityList(){

        // Create instances of cities in ArrayList container
        ArrayList<City> cityList = new ArrayList<>();
        City clemson = new City("Clemson", 34.683437, -82.837364);
        City greenville = new City("Greenville", 34.852619, -82.394012);
        City charlotte = new City("Charlotte", 35.227085, -80.843124);
        City spartanburg = new City("Spartanburg", 34.9435779, -81.925875);
        City anderson = new City("Anderson", 34.503441, -82.650131);
        City new_york = new City("New York", 40.730610, -73.935242);
        City washington_dc = new City("Washington D.C.", 38.889484, -77.035278);
        City san_diego = new City("San Diego", 32.715736, -117.161087);
        City columbia = new City("Columbia", 34.0007104, -81.0348144);
        City charleston = new City("Charleston", 32.784618, -79.940918);

        /* ----------------------- QUESTION ---------------------------------- */
        // DO WE WANT TO PICK SOME CITIES THAT ARE A LITTLE MORE DISPERSED?
        // SO THAT WE CAN PROVE IT WORKS WITH LATS AND LONGS ALL OVER THE SPECTRUM

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
