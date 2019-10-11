package com.tylerlowrey.one_hw3;

import java.util.ArrayList;

public class City {
    private String name;
    private double latitude;
    private double longitude;

    /*
     * Functionality: Constructor with arguments to create City with values
     * PreConditions: cityName must be a valid string, latitude and longitude must be valid doubles
     * PostConditions: instance of City is created and private variables are set
     */
    public City (String cityName, double latitude, double longitude){
        name = cityName;
        this.latitude = latitude;
        this.longitude = longitude;
    }   //end of constructor



    /* --------------------- Getters and Setters for class private variables ----------------
     * Functionality: get and set private variables for City Class
     * PreConditions: City class must be initialized
     * PostConditions: a specific private variable is either returned to the user, or set to a value
     */
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }


    /*
     * Functionality: Creates list of cities and returns them to the fragment for display
     * PreConditions: none
     * PostConditions: An Array list of already initialized cities is returned
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
