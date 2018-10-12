package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class QuakeAdapter extends ArrayAdapter<Earthquake> {

    public QuakeAdapter(Context context, List<Earthquake> quake) {
        super(context, 0, quake);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.quake_list_activity, parent, false);

        }

        Earthquake currentEarthquake = getItem(position);



        double magnitudeDouble = currentEarthquake.getMagnitude();
        DecimalFormat formatter = new DecimalFormat("0.0");
        String formattedMagnitude = formatter.format(magnitudeDouble);
        TextView magnitude = listItemView.findViewById(R.id.magnitude);
        magnitude.setText(formattedMagnitude);
        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        String currentCity = currentEarthquake.getCity();
        String distanceFromCity;
        String preciseLocation;
        if (currentCity.contains(" of ")) {
            String[] division = currentCity.split(" of ");
            distanceFromCity = division[0] + " Of ";
            preciseLocation = division[1];
        } else {
            distanceFromCity = "Near The";
            preciseLocation = currentCity;
        }

        TextView distanceAway = listItemView.findViewById(R.id.distance_from_city);
        distanceAway.setText(distanceFromCity);

        TextView city = listItemView.findViewById(R.id.city);
        city.setText(preciseLocation);

        Date dateObject = new Date(currentEarthquake.getmTimeInMilliSeconds());
        TextView date = listItemView.findViewById(R.id.date);
        String formattedDate = formatDate(dateObject);
        date.setText(formattedDate);

        TextView time = listItemView.findViewById(R.id.time);
        String formattedTime = formatTime(dateObject);
        time.setText(formattedTime);

        return listItemView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
        return timeFormat.format(dateObject);
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

}


