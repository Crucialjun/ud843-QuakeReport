package com.example.android.quakereport;

/**
 * The type Earthquake.
 */
public class Earthquake {
    private double mMagnitude;
    private String mCity;
    private long mTimeInMilliSeconds;
    private String mQuakeUrl;


    /**
     * Instantiates a new Earthquake.
     *
     * @param magnitude the magnitude
     * @param city      the city
     */
    public Earthquake(double magnitude, String city, long timeInMilliseconds,String quakeUrl) {
        mMagnitude = magnitude;
        mCity = city;
        mTimeInMilliSeconds = timeInMilliseconds;
        mQuakeUrl = quakeUrl;



    }

    /**
     * Gets magnitude.
     *
     * @return the magnitude
     */
    public double getMagnitude() {
        return mMagnitude;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
        return mCity;
    }


    public long getmTimeInMilliSeconds(){
        return mTimeInMilliSeconds;
    }

    public String getQuakeUrl() {
        return mQuakeUrl;
    }
}
